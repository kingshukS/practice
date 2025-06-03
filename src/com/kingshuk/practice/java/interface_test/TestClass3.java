package com.kingshuk.practice.java.interface_test;

/**
 * This class implements two interfaces: TestInterface and TestInterface2.
 * It provides implementations for the methods defined in these interfaces.
 */
public class TestClass3 implements TestInterface, TestInterface2{
    // Implementing the showMessage method from TestInterface
    @Override
    public void showMessage(String message) {
        System.out.println("Message from TestClass3: " + message);
    }

    /**
     * This method overrides the default method from both TestInterface and TestInterface2.
     * It demonstrates how to call the default methods from both interfaces.
     */
    @Override
    public void printDefaultMessage() {
        // To call the interface level default methods, we need to specify the interface name with super
        TestInterface.super.printDefaultMessage();
        TestInterface2.super.printDefaultMessage();
        System.out.println("This is a custom default message from TestClass3.");
        // If you want to call the static method from TestInterface, we can do so like this, not via instance or this:
        TestInterface.printStaticMessage();
        // You can't call the static method from TestInterface3: compilation error
        //TestInterface3.printStaticMessage();
    }
}
