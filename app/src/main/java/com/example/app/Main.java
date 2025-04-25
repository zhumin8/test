package com.example.app;

import com.example.lib.Checker;
import com.google.cloud.workflows.v1.LocationName;
// import com.google.cloud.workflows.v1beta.CreateWorkflowRequest;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    try {
      // CreateWorkflowRequest.newBuilder();
      LocationName.newBuilder();
      System.out.println("can access v1/LocationName directly");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    if(Checker.checkIfV1LocationNamePresent()) {
      System.out.println("can access via library");
    } else {
      System.out.println("cannot access via library");
    }
  }
}