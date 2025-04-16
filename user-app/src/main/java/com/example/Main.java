package com.example;

import com.google.cloud.workflows.v1.LocationName;
import com.google.cloud.workflows.v1beta.CreateWorkflowRequest;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Shows access to artifact from both v1 and v1beta is accessible
        CreateWorkflowRequest.newBuilder();
        LocationName.newBuilder();
        
    }
}