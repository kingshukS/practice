package com.kingshuk.tests.Designpatterns.Creational.Singleton;

import java.io.Serializable;

/**
 * It is called double-checked locking because there are two checks for instance == null,
 * one without locking and other with locking (inside synchronized) block.
 * <p>
 * Note the local variable "localRef", which seems unnecessary. The effect of this is that in cases where helper is already initialized
 * (i.e., most of the time), the volatile field is only accessed once (due to "return localRef;" instead of "return instance;"),
 * which can improve the method's overall performance by as much as 40 percent.
 */
public class ThreadSafeSingleton implements Serializable {

    private static final long serialVersionUID = 2256667231949650806L;
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton () {
    }

    public static ThreadSafeSingleton getInstance () {
        ThreadSafeSingleton localRef = instance;
        if ( localRef == null ) {
            synchronized (ThreadSafeSingleton.class) {
                localRef = instance;
                if ( localRef == null ) {
                    localRef = instance = new ThreadSafeSingleton ();
                }
            }
        }
        return localRef;
    }

    protected Object readResolve () {
        return getInstance ();
    }
}
