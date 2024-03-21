package com.kingshuk.tests.multithreading;

public class HelloWorldRunner {
    public static void main ( String[] args ) throws InterruptedException {
        HelloWorldPrinter printer = new HelloWorldPrinter ();
        printer.start ();
        for ( int i = 0; i < 10; i++ ) {
            System.out.println ( Thread.currentThread ().getName () + ": Hello World!!" );
            Thread.sleep ( 700 );
        }
    }
}
