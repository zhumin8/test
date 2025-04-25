package com.example.lib;

import com.google.cloud.workflows.v1.LocationName;
// import com.google.cloud.workflows.v1beta.CreateWorkflowRequest;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Shows access to artifact from both v1 and v1beta is accessible
        // CreateWorkflowRequest.newBuilder();
        LocationName.newBuilder();
        if (isClassInPath("com.google.cloud.workflows.v1.LocationName")) {
            System.out.println("Yes! v1.LocationName is accessible");
        } else {
            System.out.println("NO! cannot find v1.LocationName");
        }
        
    }

    public static boolean isClassInPath(String className) {
        try {
            Class.forName(className); // Replace "com.example.MyClass" with the actual class name
            System.out.println("Class '"+ className + "' found in classpath");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Class '"+ className + "' not found in classpath");
            return false;
        }
    }
}