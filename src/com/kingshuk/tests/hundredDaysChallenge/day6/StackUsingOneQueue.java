package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    Queue<Integer> mainQueue;

    public StackUsingOneQueue () {
        mainQueue = new LinkedList<> ();
    }

    public static void main ( String[] args ) {
        StackUsingOneQueue stack = new StackUsingOneQueue ();
        stack.push ( 10 );
        stack.push ( 20 );
        stack.push ( 30 );
        System.out.println ( stack.peek () );
        System.out.println ( stack.pop () );
        System.out.println ( stack.peek () );
        System.out.println ( stack.pop () );
        System.out.println ( stack.peek () );
        System.out.println ( stack.pop () );
        System.out.println ( stack.empty () );
    }

    public void push ( int x ) {
        mainQueue.add ( x );
        int size = mainQueue.size ();
        while (size > 1) {
            mainQueue.add ( mainQueue.poll () );
            size--;
        }
    }

    public int pop () {
        if ( mainQueue.isEmpty () )
            return - 1;
        return mainQueue.poll ();
    }

    public int peek () {
        if ( mainQueue.isEmpty () )
            return - 1;
        return mainQueue.peek ();
    }

    public boolean empty () {
        return mainQueue.isEmpty ();
    }
}
