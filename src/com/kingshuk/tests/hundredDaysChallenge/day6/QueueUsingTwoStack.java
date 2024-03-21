package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.Stack;

class QueueUsingTwoStack {
    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public QueueUsingTwoStack () {
        mainStack = new Stack<> ();
        tempStack = new Stack<> ();
    }

    public void push ( int x ) {
        mainStack.push ( x );
    }

    public int pop () {
        if ( ! tempStack.isEmpty () )
            return tempStack.pop ();
        if ( mainStack.isEmpty () )
            return - 1;
        while (mainStack.size () > 0) {
            tempStack.push ( mainStack.pop () );
        }
        return tempStack.pop ();
    }

    public int peek () {
        if ( ! tempStack.isEmpty () )
            return tempStack.peek ();
        if ( mainStack.isEmpty () )
            return - 1;
        while (mainStack.size () > 0) {
            tempStack.push ( mainStack.pop () );
        }
        return tempStack.peek ();
    }

    public boolean empty () {
        return tempStack.isEmpty () && mainStack.isEmpty ();
    }
}