package com.retail.gui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;
import retail.OrderRequest;
import retail.OrderResponse;
import retail.RecommendationServiceGrpc;
import retail.Retail.Product;
import retail.Retail.RecommendationRequest;
import retail.OrchestratorServiceGrpc;


@Controller
public class RetailController {
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Smart Retail GUI");
        return "index";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam String userId,@RequestParam int quantity,Model model){
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
