package com.kingshuk.practice.java.static_method_test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Static methods get inherited in case of Class level, but not for the Interfaces");
        System.out.println("--------------------");
        ClassA objA = new ClassB();
        objA.instanceMethod();
        objA.staticMethod();
        System.out.println("--------------------");

        // Calling the static method directly from ClassA: recommended
        ClassA.staticMethod();
        System.out.println("--------------------");

        // Calling the static method of ClassA directly from ClassB, if ClassB doesn't hide it: not recommended
        ClassB.staticMethod();
        System.out.println("--------------------");

        // This will still call ClassA's static method, if ClassB doesn't hide it
        ClassB objB = new ClassB();
        objB.staticMethod();
    }
}
