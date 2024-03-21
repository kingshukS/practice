package com.kingshuk.tests.misc;

class SequentialRun implements Runnable {

    @Override
    public void run () {
        for ( int i = 0; i < 5; i++ ) {
            System.out.println ( "For i : " + i + " of thread " + Thread.currentThread ().getName () );
        }
    }
}

public class ThreadSequence {

    public static void main ( String[] args ) {
        SequentialRun sqr = new SequentialRun ();
        Thread t1 = new Thread ( sqr, "Thread1" );
        Thread t2 = new Thread ( sqr, "Thread2" );
        Thread t3 = new Thread ( sqr, "Thread3" );
        try {
            t1.start ();
            t1.join ();
            t2.start ();
            t2.join ();
            t3.start ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
