package com.kingshuk.tests.ProducerConsumer;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {

    private final Queue<Integer> queue;
    private final int maxSize;
    public Producer(Queue<Integer> queue,int maxSize)
    {
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run()
    {
        while (true)
        {
            synchronized (queue) //The wait and notify methods are called on objects that are being used as locks.
            {
                while(queue.size()==maxSize)
                {
                    try {
                        System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}
