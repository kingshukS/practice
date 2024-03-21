package com.kingshuk.tests.Designpatterns.Creational.Singleton;

import java.io.*;

public class SingletonSerializedTest {

    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
        ThreadSafeSingleton instanceOne = ThreadSafeSingleton.getInstance ();
        ObjectOutput out = new ObjectOutputStream ( new FileOutputStream (
                "filename.ser" ) );
        out.writeObject ( instanceOne );
        out.close ();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream ( new FileInputStream (
                "filename.ser" ) );
        ThreadSafeSingleton instanceTwo = (ThreadSafeSingleton) in.readObject ();
        in.close ();

        System.out.println ( "instanceOne hashCode=" + instanceOne.hashCode () );
        System.out.println ( "instanceTwo hashCode=" + instanceTwo.hashCode () );

    }

}