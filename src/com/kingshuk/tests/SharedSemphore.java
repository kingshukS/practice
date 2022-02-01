package com.kingshuk.tests;

import java.util.concurrent.Semaphore;

public class SharedSemphore implements PrintOddEve{

    Semaphore OddSem = new Semaphore(1);
    Semaphore EvenSem = new Semaphore(0);
    @Override
    public void printEven(int number) {
    try
    {
        EvenSem.acquire();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " :"+number);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OddSem.release();
    }

    @Override
    public void printOdd(int number) {
    try {
        OddSem.acquire();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " :"+number);
    try{
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

        EvenSem.release();
    }
}
