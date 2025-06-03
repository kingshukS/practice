package com.kingshuk.practice.java.static_method_test;

// ClassB.java
public class ClassB extends ClassA{

    @Override
    public void instanceMethod() {
        super.instanceMethod();
        System.out.println("This is an instance method in ClassB.");
    }

    // Static method in ClassB that hides the static method in ClassA
    public static void staticMethod() {
        System.out.println("This is a static method in ClassB.");
    }
}
