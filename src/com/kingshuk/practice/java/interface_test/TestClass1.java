package com.kingshuk.practice.java.interface_test;

// TestClass1.java
public class TestClass1 implements TestInterface{
    // Implementing the showMessage method from TestInterface
    @Override
    public void showMessage(String message) {
        System.out.println("Message from TestClass1: " + message);
    }
    // No need to override the default method from TestInterface
}
