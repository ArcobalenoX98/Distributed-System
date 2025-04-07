package com.retail.recommendation;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import retail.Retail.Product;
import retail.Retail.RecommendationRequest;
import retail.RecommendationServiceGrpc;

import java.io.IOException;

public class RecommendationClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        RecommendationServiceGrpc.RecommendationServiceBlockingStub stub =
                RecommendationServiceGrpc.newBlockingStub(channel);

        RecommendationRequest request = RecommendationRequest.newBuilder()
                .setUserId("user123")
                .build();

        System.out.println(" Sending recommendation request...");

        stub.getRecommendations(request).forEachRemaining(product -> {
            System.out.println(" Product: " + product.getName() + " - $" + product.getPrice());
        });

        channel.shutdown();
    }
    
}
