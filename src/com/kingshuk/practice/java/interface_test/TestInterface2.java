package com.kingshuk.practice.java.interface_test;

public interface TestInterface2 {

    // Abstract method to be implemented by classes
    default void printDefaultMessage() {
        System.out.println("This is a default message from TestInterface2.");
    }
}
