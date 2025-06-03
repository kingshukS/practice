package com.kingshuk.practice.java.interface_test;

// TestClass2.java
public class TestClass2 implements TestInterface{
    // Implementing the showMessage method from TestInterface
    @Override
    public void showMessage(String message) {
        System.out.println("Message from TestClass2: " + message);
    }

    // Overriding the default method from TestInterface
    @Override
    public void printDefaultMessage() {
        System.out.println("This is a custom default message from TestClass2.");
    }
}
