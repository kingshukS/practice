package com.kingshuk.tests.multithreading;

public class HelloWorldPrinter extends Thread {

    @Override
    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+": Hello World!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
