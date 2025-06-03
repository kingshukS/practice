package com.kingshuk.practice.java.interface_test;

// TestInterface.java
public interface TestInterface {

    // Abstract method to be implemented by classes
    void showMessage(String message);

    // Default method with a body
    default void printDefaultMessage() {
        System.out.println("This is a default message from the TestInterface.");
    }

    // Static method with a body
    static void printStaticMessage() {
        System.out.println("This is a static message from the TestInterface.");
    }
}
