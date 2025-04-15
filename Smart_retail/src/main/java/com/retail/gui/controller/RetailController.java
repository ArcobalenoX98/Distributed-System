package com.retail.gui.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;
import retail.OrderRequest;
import retail.OrderResponse;
import retail.RecommendationServiceGrpc;
import retail.Retail;
import retail.Retail.Product;
import retail.Retail.ProductList;
import retail.Retail.RecommendationRequest;
import retail.OrchestratorServiceGrpc;
import retail.InventoryServiceGrpc;

import com.google.protobuf.Empty;


@Controller
public class RetailController {
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Smart Retail GUI");

        //pull the list of procuct from Inventory
        List<Retail.Product> inventory = new ArrayList();
        try {
            ManagedChannel inventoryChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

            InventoryServiceGrpc.InventoryServiceBlockingStub stub3 = InventoryServiceGrpc.newBlockingStub(inventoryChannel);

            /* 
            Empty request3 = Empty.newBuilder().build();
            Iterator<Retail.Product> products = stub3.getInventory(request3);

            while(products.hasNext()){
                inventory.add(products.next());
            }
            */

            Empty emptyRequest = Empty.newBuilder().build();
            ProductList productList = stub3.getInventory(emptyRequest);
            inventory.addAll(productList.getProductsList());

            Retail.StockRequest stockRequest = Retail.StockRequest.newBuilder().setProductId("example-product-id").build();
            Retail.StockResponse stockResponse = stub3.getStock(stockRequest);

            //add a produt for test
            Retail.Product sampleProduct = Retail.Product.newBuilder()
                .setProductId("example-product-id")
                .setName("Sample Product")
                .setPrice(10.0)
                .build();
            inventory.add(sampleProduct);

            //print log
            for(Retail.Product product : inventory){
                System.out.println("Loaded product:" + product.getProductId() + "-" + product.getName());
            }

            System.out.println("Number of inventory is:" + stockResponse.getQuantity());
            inventoryChannel.shutdown();

        } catch (Exception e) {
            System.out.println("Inventory fetch error:" + e.getMessage());
        }
        model.addAttribute("inventoryList",inventory);
        return "index";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam String userId,@RequestParam int quantity,Model model){

        //Retail.CartItem item = Retail.CartItem.newBuilder().setProductId(productID).setQuantity(quantity).build();

        // connect to the Orchestrator service
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50053).usePlaintext().build();
        OrchestratorServiceGrpc.OrchestratorServiceBlockingStub stub = OrchestratorServiceGrpc.newBlockingStub(channel);

        OrderRequest request = OrderRequest.newBuilder().setUserId(userId).setQuantity(quantity).build();

        OrderResponse response = stub.processOrder(request);
        channel.shutdown();

        model.addAttribute("title","Smart Retail Result");
        model.addAttribute("result",response.getSuccess());
        model.addAttribute("message",response.getMessage());

        //recommendation Service
        List<Product> recommendations = new ArrayList<>();
        try{
            ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();
            RecommendationServiceGrpc.RecommendationServiceBlockingStub stub2 = RecommendationServiceGrpc.newBlockingStub(channel2);

            RecommendationRequest request2 = RecommendationRequest.newBuilder().setUserId(userId).build();

            Iterator<Product> products = stub2.getRecommendations(request2);
            while(products.hasNext()){
                recommendations.add(products.next());
            }
            channel2.shutdown();
        } catch(Exception e){
            System.out.println("Failed to get recommendations:" + e.getMessage());
        }
        model.addAttribute("recommendations",recommendations);

        return "result";
    }

}
