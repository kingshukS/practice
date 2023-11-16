package com.kingshuk.tests.misc;
public class YieldProgram {
    public static void main(String[] args)
    {
        Thread t1 = new Producer1();
        Thread t2 = new Consumer1();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}

class Producer1 extends Thread{
    @Override
    public void run()
    {
        for(int i =0;i<5;i++)
        {
            System.out.println("Thread executing is producer "+Thread.currentThread().getName()+" "+i);
            Thread.yield();
        }
    }
}

class Consumer1 extends Thread{
    public void run()
    {
        for(int i =0;i<5;i++)
        {
            System.out.println("Thread executing is consumer "+Thread.currentThread().getName()+" "+i);
            Thread.yield();
        }
    }
}
