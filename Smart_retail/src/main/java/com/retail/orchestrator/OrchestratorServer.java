package com.retail.orchestrator;

import retail.OrchestratorServiceGrpc;
import retail.OrderRequest;
import retail.OrderResponse;
import retail.CheckoutServiceGrpc;
import retail.Retail;
import retail.Retail.StockRequest;
import retail.Retail.StockResponse;
import retail.RecommendationServiceGrpc;
import retail.Retail.RecommendationRequest;
import retail.Retail.Product;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import retail.InventoryServiceGrpc;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

public class OrchestratorServer {
    private static final Logger logger = Logger.getLogger(OrchestratorServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50053)
                .addService(new OrchestratorServiceImpl())
                .build();
        server.start();
        logger.info("Orchestrator gRPC server started on port 50053");
        server.awaitTermination();
    }

    static class OrchestratorServiceImpl extends OrchestratorServiceGrpc.OrchestratorServiceImplBase {
        @Override
        public void processOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {

            // 1. Inventory Check (Call Inventory service)
            ManagedChannel inventoryChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            InventoryServiceGrpc.InventoryServiceBlockingStub inventoryStub = InventoryServiceGrpc.newBlockingStub(inventoryChannel);
            StockResponse inventoryResponse = inventoryStub.getStock(
                    StockRequest.newBuilder().setProductId("123").build()
            );
            inventoryChannel.shutdown();

            String userId = request.getUserId();
            logger.info("Processing order for user: " + userId);
            logger.info("receive request: userId=" + request.getUserId() + ",quantity=" +request.getQuantity());
            logger.info("inventory back: quantity=" + inventoryResponse.getQuantity());


            // 2. Checkout (Call Checkout service)
            ManagedChannel checkoutChannel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
            CheckoutServiceGrpc.CheckoutServiceStub checkoutStub = CheckoutServiceGrpc.newStub(checkoutChannel);

            Retail.CartItem item = Retail.CartItem.newBuilder().setProductId("123").setQuantity(1).build();
            StreamObserver<Retail.CheckoutResponse> checkoutResponseObserver = new StreamObserver<Retail.CheckoutResponse>() {
                @Override
                public void onNext(Retail.CheckoutResponse checkoutResponse) {
                    String msg = "Inventory Available: " + inventoryResponse.getQuantity()
                            + ", Checkout Success: " + checkoutResponse.getSuccess();

                    OrderResponse response = OrderResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage(msg)
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }

                @Override
                public void onError(Throwable t) {
                    logger.warning("Checkout error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    checkoutChannel.shutdown();
                }
            };


            // 3 Recommendation (call Recommendation service)
            ManagedChannel recommendationChannel = ManagedChannelBuilder.forAddress("localhost",50051)
                    .usePlaintext()
                    .build();
            RecommendationServiceGrpc.RecommendationServiceBlockingStub recommendationStub =
                    RecommendationServiceGrpc.newBlockingStub(recommendationChannel);

                //constructor requist
            RecommendationRequest recRequest = RecommendationRequest.newBuilder()
                    .setUserId(request.getUserId())
                    .build();

                //useing the grpc server-streaming,access the recommendation
            Iterator<Product> products = recommendationStub.getRecommendations(recRequest);

            System.out.println("Recommended Products:");
            while(products.hasNext()){
                retail.Retail.Product p = products.next();
                System.out.println("-" + p.getName() + ":" + p.getPrice() + "Euro");
            }


            StreamObserver<Retail.CartItem> requestObserver = checkoutStub.checkout(checkoutResponseObserver);
            requestObserver.onNext(item);
            requestObserver.onCompleted();
        }
    }
}
