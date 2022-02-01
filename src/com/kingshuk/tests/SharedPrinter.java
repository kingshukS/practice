package com.kingshuk.tests;

public class SharedPrinter implements PrintOddEve {

    boolean isOddPrinted = false;
    @Override
    public synchronized void printOdd(int number)
    {
        while (isOddPrinted)
        {
            try{
                wait();
            }
            catch (InterruptedException e )
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" :"+number);
            isOddPrinted = true;
            try
            {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }
    @Override
    public synchronized void printEven(int number)
    {
        while(!isOddPrinted)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " :" +number);
            isOddPrinted = false;
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }
}
