package com.kingshuk.tests.Designpatterns.Creational.Singleton;

/**
 * Let's take a look at the comments:
 * <p>
 * // static inner class - inner classes are not loaded until they are referenced.
 * <p>
 * The "loading" is the process of initialising the inner class (BillPughSingletonHelper).
 * <p>
 * "until they are referenced" means the inner class (BillPughSingletonHelper) is not initialised until the BillPughSingletonHelper.INSTANCE static field
 * is referenced in this case.
 * <p>
 * So the call to getInstance() references BillPughSingletonHelper.INSTANCE and starts the initialisation of the BillPughSingletonHelper inner class.
 * <p>
 * The whole process of initialising a class is synchronised by the JVM.
 * <p>
 * From the relevant documentation:
 * <p>
 * Because the Java programming language is multithreaded, initialization of a class or interface requires careful synchronization
 * <p>
 * The implementation of the Java Virtual Machine is responsible for taking care of synchronization and recursive initialization
 * <p>
 * The initialisation of the static field:
 * <p>
 * private static final BillPughSingleton INSTANCE = new BillPughSingleton();
 * is a part of the inner class initialisation and this whole initialisation process ("loading") is effectively synchronised by the JVM.
 */
public class BillPughSingleton {

    private BillPughSingleton () {
    }

    private static BillPughSingleton getInstance () {
        return BillPughSingletonHelper.INSTANCE;
    }

    private static class BillPughSingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton ();
    }
}
