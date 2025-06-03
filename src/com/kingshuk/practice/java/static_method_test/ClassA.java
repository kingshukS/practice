package com.kingshuk.practice.java.static_method_test;

// ClassA.java
public class ClassA {

    // Static method that can be called without an instance of ClassA
    public static void staticMethod() {
        System.out.println("This is a static method in ClassA.");
    }

    // Instance method that can be overridden by subclasses
    public void instanceMethod() {
        System.out.println("This is an instance method in ClassA.");
    }
}
