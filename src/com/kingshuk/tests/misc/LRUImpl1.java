package com.kingshuk.tests.misc;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUImpl1 {

    Set<Integer> cache;
    int capacity;

    public LRUImpl1 ( int capacity ) {
        this.cache = new LinkedHashSet<Integer> ( capacity );
        this.capacity = capacity;
    }

    public static void main ( String[] args ) {
        LRUImpl1 ca = new LRUImpl1 ( 4 );
        ca.get ( 1 );
        ca.get ( 3 );
        ca.get ( 4 );
        ca.get ( 7 );
        ca.get ( 3 );
        ca.get ( 6 );
        ca.get ( 7 );
        ca.display ();
    }

    public boolean get ( int key ) {
        if ( ! cache.contains ( key ) )
            put ( key );
        cache.remove ( key );
        cache.add ( key );
        return true;
    }

    // display contents of cache
    public void display () {
        Iterator<Integer> itr = cache.iterator ();
        while (itr.hasNext ()) {
            System.out.print ( itr.next () + " " );
        }
    }

    public void put ( int key ) {
        if ( cache.size () == capacity ) {
            int firstKey = cache.iterator ().next ();
            cache.remove ( firstKey );
        }

        cache.add ( key );
    }
}
