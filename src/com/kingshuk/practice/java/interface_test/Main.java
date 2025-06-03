package com.kingshuk.practice.java.interface_test;

public class Main {
    public static void main(String[] args) {
        TestInterface testInterface = new TestClass1();
        testInterface.showMessage("Hello from TestClass1!");
        testInterface.printDefaultMessage();
        System.out.println("--------------------");

        testInterface = new TestClass2();
        testInterface.showMessage("Hello from TestClass2!");
        testInterface.printDefaultMessage();
        System.out.println("--------------------");

        testInterface = new TestClass3();
        testInterface.showMessage("Hello from TestClass3!");
        testInterface.printDefaultMessage();
        System.out.println("--------------------");


    }
}
