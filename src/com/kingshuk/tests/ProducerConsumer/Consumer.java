package com.kingshuk.tests.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Consumer ( Queue<Integer> queue, int maxSize ) {
        //   super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run () {
        synchronized (queue) {
            while (queue.isEmpty ()) {
                try {
                    queue.wait ();
                    wait ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
            System.out.println ( "Consuming value : " + queue.remove () );
            queue.notifyAll ();

        }
    }
}
