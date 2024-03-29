package com.kingshuk.tests.multithreading;

public class PrintSequentialNumbers implements Runnable {
    static int number = 1;
    static Object lock = new Object ();
    int NUMBERS_TO_BE_PRINTED = 10;
    int remainder;

    PrintSequentialNumbers ( int remainder ) {
        this.remainder = remainder;
    }

    public static void main ( String[] args ) {
        PrintSequentialNumbers runnable1 = new PrintSequentialNumbers ( 1 );
        PrintSequentialNumbers runnable2 = new PrintSequentialNumbers ( 2 );
        PrintSequentialNumbers runnable3 = new PrintSequentialNumbers ( 0 );

        Thread t1 = new Thread ( runnable1, "T1" );
        Thread t2 = new Thread ( runnable2, "T2" );
        Thread t3 = new Thread ( runnable3, "T3" );

        t1.start ();
        t2.start ();
        t3.start ();


    }

    @Override
    public void run () {
        while (number < NUMBERS_TO_BE_PRINTED - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait ();
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
                System.out.println ( Thread.currentThread ().getName () + " : " + number );
                number++;
                lock.notifyAll ();
            }
        }
    }
}
