package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.Stack;

class QueueUsingOneStack {
    Stack<Integer> mainStack;

    public QueueUsingOneStack () {
        mainStack = new Stack<> ();
    }

    public static void main ( String[] args ) {
        QueueUsingOneStack queue = new QueueUsingOneStack ();
        queue.push ( 10 );
        queue.push ( 20 );
        queue.push ( 30 );
        System.out.println ( queue.peek () );
        System.out.println ( queue.pop () );
        System.out.println ( queue.peek () );
        System.out.println ( queue.pop () );
        System.out.println ( queue.peek () );
        System.out.println ( queue.pop () );
    }

    public void push ( int x ) {
        mainStack.push ( x );
    }

    public int pop () {
        if ( mainStack.isEmpty () )
            return - 1;
        if ( mainStack.size () == 1 )
            return mainStack.pop ();
        int data = mainStack.pop ();
        int val = pop ();
        mainStack.push ( data );
        return val;
    }

    public int peek () {
        if ( mainStack.isEmpty () )
            return - 1;
        if ( mainStack.size () == 1 )
            return mainStack.peek ();
        int data = mainStack.pop ();
        int val = peek ();
        mainStack.push ( data );
        return val;
    }

    public boolean empty () {
        return mainStack.isEmpty ();
    }
}