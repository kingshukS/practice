package com.kingshuk.tests.Designpatterns;

public class Singleton1 {

    private static volatile Singleton1 instance;
    private static int count = 0;
    private static Object lock = new Object();
    public static Singleton1 GetInstance()
    {
        Singleton1 result = instance;
        if(instance == null)
        {
            synchronized (lock)
            {
                result = instance;
                if(instance == null)
                    instance = result = new Singleton1();
            }

        }
        return result;
    }
    private Singleton1()
    {
        count++;
        System.out.println(count);
    }

    public static void main(String args[])
    {
        Singleton1 s1 = Singleton1.GetInstance();
        Singleton1 s2 = Singleton1.GetInstance();
    }
}
