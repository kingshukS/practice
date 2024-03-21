package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.Stack;

class MyQueue {

    Stack<Integer> mainStack;

    public MyQueue () {
        mainStack = new Stack<> ();
    }

    public void push ( int x ) {
        mainStack.push ( x );
    }

    public int pop () {
        if ( mainStack.isEmpty () )
            return - 1;
        if ( mainStack.size () == 1 )
            return mainStack.pop ();
        int x = mainStack.pop ();
        int k = this.pop ();
        mainStack.push ( x );
        return k;
    }

    public int peek () {
        if ( mainStack.isEmpty () )
            return - 1;
        if ( mainStack.size () == 1 )
            return mainStack.peek ();
        int x = mainStack.pop ();
        int k = this.pop ();
        mainStack.push ( x );
        return k;
    }

    public boolean empty () {
        return mainStack.isEmpty ();
    }
}