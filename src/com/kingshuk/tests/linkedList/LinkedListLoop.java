package com.kingshuk.tests.linkedList;

import com.kingshuk.tests.JustPractice.LLNode;

public class LinkedListLoop {
    private LLNode startNode;

    public static void main ( String[] args ) {
        LinkedListLoop linkedListLoop = new LinkedListLoop ();

        LLNode n1 = new LLNode ( 10 );
        LLNode n2 = new LLNode ( 20 );
        LLNode n3 = new LLNode ( 30 );
        LLNode n4 = new LLNode ( 40 );
        LLNode n5 = new LLNode ( 50 );
        LLNode n6 = new LLNode ( 60 );

        linkedListLoop.startNode = n1;

        n1.setNext ( n2 );
        n2.setNext ( n3 );
        n3.setNext ( n4 );
        n4.setNext ( n5 );
        n5.setNext ( n6 );
        n6.setNext ( null );
        if ( isLoopPresent ( linkedListLoop.startNode ) ) {
            System.out.println ( "loop exits in this linked list" );
        } else {
            System.out.println ( "no loop exits in this linked list" );
        }
    }

    private static boolean isLoopPresent ( LLNode startNode ) {
        LLNode slowpointer = startNode;
        LLNode fastPointer = startNode;
        while (fastPointer != null && slowpointer.getNext () != null) {
            slowpointer = slowpointer.getNext ();
            fastPointer = fastPointer.getNext ().getNext ();
            if ( slowpointer == fastPointer ) {
                return true;
            }
        }
        return false;
    }

}


