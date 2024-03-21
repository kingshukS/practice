package com.kingshuk.tests.misc;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {

    Queue<Integer> queue = new LinkedList<> ();

    public static void main ( String[] args ) {
        StackUsingOneQueue stackUsingOneQueue = new StackUsingOneQueue ();
        stackUsingOneQueue.push ( 10 );
        stackUsingOneQueue.push ( 20 );
        stackUsingOneQueue.push ( 30 );
        stackUsingOneQueue.push ( 40 );

        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();


        stackUsingOneQueue.push ( 50 );
        stackUsingOneQueue.push ( 60 );

        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();
        stackUsingOneQueue.pop ();

    }

    public void push ( int data ) {
        queue.add ( data );
        int size = queue.size ();
        while (size > 1) {
            queue.add ( queue.remove () );
            size--;
        }
    }

    public void pop () {
        if ( queue.isEmpty () ) {
            System.out.println ( "Nothing to pop,queue is empty" );
        } else {
            System.out.println ( queue.poll () );
        }
    }
}
