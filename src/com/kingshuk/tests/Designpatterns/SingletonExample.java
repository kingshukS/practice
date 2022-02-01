package com.kingshuk.tests.Designpatterns;

class SingletonEagar {
    private static SingletonEagar instance = new SingletonEagar();
    //here we straight away initialize a class variable and instance is made
    private SingletonEagar(){}
    public static SingletonEagar getInstance() {
        return instance;
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) {
            //this is lazy initialization where we create the object after checking it as null
            //but this is not thread safe
            //might be a case 2 threads came at the same time both read values
            // as null and hence 2 different objects are created
            instance = new Singleton();
        }

        return instance;
    }
}

class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){}

    public static synchronized SingletonSynchronizedMethod getInstance() {
        //this is a thread safe way
        //bt this has made the whole method synchronized,no need to make reads sync
        if(instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized(){}

    public static SingletonSynchronized getInstance() {
        if(instance == null) {
            synchronized (SingletonSynchronized.class) {
                //so using sync block where only writing block will be sync
                // 2 threads came one is writing ,other can read the instance value
                if(instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();

        System.out.println(instance);

        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();

        System.out.println(instance1);
    }
}