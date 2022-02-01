package com.kingshuk.tests.Designpatterns;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPractice {
    public static void main(String args[])
    {
        EagerInit e2 = EagerInit.getInstance();
        EagerInit e1 = EagerInit.getInstance();
        EagerInit e = null;
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        try {
            Class<EagerInit> clazz = EagerInit.class;
            Constructor<EagerInit> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            e = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e.hashCode());

    }

}

class EagerInit{
    private static final EagerInit instance = new EagerInit();

    private EagerInit(){

    //    if(instance!=null)
       //     throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    };
    public static EagerInit getInstance(){
        return instance;
    }
}
class LazyInitialization{

    private static LazyInitialization instance = null;

    private LazyInitialization(){};

    public static LazyInitialization getInstance(){
        if(instance==null)
           instance =  new LazyInitialization();
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){};

    public static synchronized ThreadSafeSingleton getInstance()
    {
        if(instance==null)
            instance = new ThreadSafeSingleton();
        return instance;
    }
}

class SyncClassSingleton{

    private static SyncClassSingleton instance;
    private SyncClassSingleton(){};
    public static SyncClassSingleton getInstance(){
        if(instance==null)
        {
            synchronized (SyncClassSingleton.class)
            {
                if(instance==null)
                    instance = new SyncClassSingleton();
            }
        }
        return instance;
    }
}
