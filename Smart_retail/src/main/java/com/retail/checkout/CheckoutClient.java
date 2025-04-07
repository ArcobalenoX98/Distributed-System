package com.retail.checkout;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import retail.Retail.CartItem;
import retail.Retail.CheckoutResponse;
import retail.CheckoutServiceGrpc;

import java.util.Iterator;

public class CheckoutClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        CheckoutServiceGrpc.CheckoutServiceStub stub = CheckoutServiceGrpc.newStub(channel);

        io.grpc.stub.StreamObserver<CartItem> requestObserver =
            stub.checkout(new io.grpc.stub.StreamObserver<CheckoutResponse>() {
                @Override
                public void onNext(CheckoutResponse response) {
                    System.out.println("Checkout result: " + response.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println(" Error during checkout: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Checkout request completed.");
                    channel.shutdown();
                }
            });

        requestObserver.onNext(CartItem.newBuilder().setProductId("p1").setQuantity(2).build());
        requestObserver.onNext(CartItem.newBuilder().setProductId("p2").setQuantity(1).build());

        requestObserver.onCompleted();
    }
}