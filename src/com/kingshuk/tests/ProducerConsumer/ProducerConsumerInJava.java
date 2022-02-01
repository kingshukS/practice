package com.kingshuk.tests.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class ProducerConsumerInJava {
    public static void main(String[] args)
    {
        System.out.println("ProducerConsumer problem through wait notify");

        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Producer producer = new Producer(buffer,maxSize);
        Consumer consumer = new Consumer(buffer,maxSize);
        Thread t1 = new Thread(producer,"Producer");
        Thread t2 = new Thread(consumer,"Consumer");
        t1.start();
        t2.start();
    }
}
