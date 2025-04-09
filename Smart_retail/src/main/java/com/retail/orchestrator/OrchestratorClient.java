package com.retail.orchestrator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import retail.OrchestratorServiceGrpc;
import retail.OrderRequest;
import retail.OrderResponse;


public class OrchestratorClient {
    public static void main(String[] args){
        //1.connect orchetrator
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50053).usePlaintext().build();

        //2.create the Stub for synchronous blocking
        OrchestratorServiceGrpc.OrchestratorServiceBlockingStub stub = OrchestratorServiceGrpc.newBlockingStub(channel);

        //3. constructor of OrderRequest 
        OrderRequest request = OrderRequest.newBuilder().setUserId("kris001").setQuantity(1).build();

        //send request and receive the response
        OrderResponse response = stub.processOrder(request);

        //5.print the result
        System.out.println("Order success:" + response.getSuccess());
        System.out.println("Message:" + response.getMessage());

        //6.close the channel
        channel.shutdown();
    }
}
