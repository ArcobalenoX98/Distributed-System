// CheckoutServer.java
package com.retail.checkout;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import retail.Retail.CheckoutResponse;
import retail.Retail.CartItem;
import retail.CheckoutServiceGrpc;

import java.io.IOException;
import java.util.logging.Logger;

public class CheckoutServer {
    private static final Logger logger = Logger.getLogger(CheckoutServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50050)
                .addService(new CheckoutServiceImpl())
                .build();

        server.start();
        logger.info("Checkout gRPC server started on port 50050");
        server.awaitTermination();
    }

    static class CheckoutServiceImpl extends CheckoutServiceGrpc.CheckoutServiceImplBase {
        @Override
        public StreamObserver<CartItem> checkout(StreamObserver<CheckoutResponse> responseObserver) {
            return new StreamObserver<CartItem>() {
                int totalItems = 0;

                @Override
                public void onNext(CartItem item) {
                    totalItems += item.getQuantity();
                    logger.info("Received cart item: " + item.getProductId() + ", quantity: " + item.getQuantity());
                }

                @Override
                public void onError(Throwable t) {
                    logger.warning("Error during checkout: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    String msg = "Processed checkout with total items: " + totalItems;
                    CheckoutResponse response = CheckoutResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage(msg)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    logger.info("Checkout completed: " + msg);
                }
            };
        }
    }
}