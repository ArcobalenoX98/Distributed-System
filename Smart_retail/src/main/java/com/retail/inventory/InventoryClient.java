package com.retail.inventory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import retail.InventoryServiceGrpc;
import retail.Retail.StockRequest;
import retail.Retail.StockResponse;

public class InventoryClient{
    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50052).usePlaintext().build();

        InventoryServiceGrpc.InventoryServiceBlockingStub stub = InventoryServiceGrpc.newBlockingStub(channel);

        System.out.println("Sending inventory check request...");
        StockRequest request = StockRequest.newBuilder().setProductId("p1").build();

        StockResponse response = stub.getStock(request);
        System.out.println("Available stock for product p1:" + response.getQuantity());

        channel.shutdown();
    }
}
