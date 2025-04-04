package com.retail.recommendation;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import retail.Retail.Product;
import retail.Retail.RecommendationRequest;
import retail.RecommendationServiceGrpc;

import java.io.IOException;

public class RecommendationServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new RecommendationServiceImpl())
                .build();

        System.out.println(" Recommendation gRPC server started on port 50051");
        server.start();
        server.awaitTermination();
    }

    static class RecommendationServiceImpl extends RecommendationServiceGrpc.RecommendationServiceImplBase {
        @Override
        public void getRecommendations(RecommendationRequest request, StreamObserver<Product> responseObserver) {
            System.out.println("📨 Received recommendation request for user: " + request.getUserId());

            Product product1 = Product.newBuilder()
                    .setProductId("P001")
                    .setName("Wireless Headphones")
                    .setPrice(89.99)
                    .build();

            Product product2 = Product.newBuilder()
                    .setProductId("P002")
                    .setName("Smart Watch")
                    .setPrice(129.99)
                    .build();

            Product product3 = Product.newBuilder()
                    .setProductId("P003")
                    .setName("Bluetooth Speaker")
                    .setPrice(59.99)
                    .build();

            // 模拟推荐列表（Server Streaming）
            responseObserver.onNext(product1);
            responseObserver.onNext(product2);
            responseObserver.onNext(product3);

            responseObserver.onCompleted(); // 告诉客户端数据传输完成
        }
    }
    
}
