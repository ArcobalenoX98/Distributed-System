package com.retail.inventory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import retail.InventoryServiceGrpc;
import retail.Retail.StockRequest;
import retail.InventoryServiceGrpc.InventoryServiceImplBase;
import retail.Retail.StockResponse;
import retail.Retail.StockResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InventoryServer{
    private Server server;

    public void start() throws IOException,InterruptedException{
        server = ServerBuilder.forPort(50052)
                .addService(new InventoryServiceImpl())
                .build()
                .start();
        System.out.println("Inventory gRPC server started on port 50052");
        server.awaitTermination();
    }

    static class InventoryServiceImpl extends InventoryServiceImplBase{
        private final Map<String,Integer> stockMap = new HashMap<>();

        public InventoryServiceImpl(){
            stockMap.put("p1",10);
            stockMap.put("p2",5);
            stockMap.put("p3",20);
        }

        @Override
        public void getStock(StockRequest request, StreamObserver<StockResponse> responseObserver){
            int quantity = stockMap.getOrDefault(request.getProductId(), 0);
            StockResponse response = StockResponse.newBuilder()
                    .setQuantity(quantity)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException{
        new InventoryServer().start();
    }
}