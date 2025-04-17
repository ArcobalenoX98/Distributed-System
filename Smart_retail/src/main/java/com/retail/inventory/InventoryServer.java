package com.retail.inventory;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import retail.InventoryServiceGrpc;
import retail.Retail.StockRequest;
import retail.InventoryServiceGrpc.InventoryServiceImplBase;
import retail.Retail.StockResponse;
import retail.Retail.StockResponse;

import com.google.protobuf.Empty;
import retail.Retail.ProductList;
import retail.Retail.Product;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        private final List<Product> productList = Arrays.asList(
            Product.newBuilder().setProductId("p001").setName("laptop").setPrice(999.99).setQuantity(10).build(),
            Product.newBuilder().setProductId("p002").setName("Smartphone").setPrice(699.99).setQuantity(5).build()
        );

        public InventoryServiceImpl(){
            stockMap.put("p1",10);
            stockMap.put("p2",5);
            stockMap.put("p3",20);
        }

        @Override
        public void getStock(StockRequest request, StreamObserver<StockResponse> responseObserver){
            //int quantity = stockMap.getOrDefault(request.getProductId(), 0);
            String productId = request.getProductId();

            int available = 0;
            for(Product p : productList){
                if(p.getProductId().equals(productId)){
                    available = p.getQuantity();
                    break;
                }
            }

            StockResponse response = StockResponse.newBuilder()
                    .setQuantity(available)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("getStock called with productId: " + request.getProductId());
        }

        public void getInventory(Empty request,StreamObserver<ProductList> responseObserver){
            System.out.println("getInventory called"); // Debug output

            ProductList.Builder response = ProductList.newBuilder();
            
            response.addProducts(Product.newBuilder().setProductId("p001").setName("laptop").setPrice(999.99));
            response.addProducts(Product.newBuilder().setProductId("p002").setName("Smartphone").setPrice(699.99));

            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException{
        new InventoryServer().start();
    }
}