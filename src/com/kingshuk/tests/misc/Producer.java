package com.kingshuk.tests.misc;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue blockingQueue = null;

    public Producer ( BlockingQueue blockingQueue ) {
        this.blockingQueue = blockingQueue;
    }

    public void run () {
        try {
            blockingQueue.put ( "1" );
            Thread.sleep ( 1000 );
            blockingQueue.put ( "2" );
            Thread.sleep ( 1000 );
            blockingQueue.put ( "3" );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
