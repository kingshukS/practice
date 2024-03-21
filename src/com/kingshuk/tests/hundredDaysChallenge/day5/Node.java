package com.kingshuk.tests.hundredDaysChallenge.day5;

import java.util.StringJoiner;

public class Node {
    public Node next;
    public int data;

    public Node ( int data ) {
        this.data = data;
    }

    public static void printList ( Node head ) {
        Node current = head;
        while (current != null) {
            System.out.print ( current.data + "->" );
            current = current.next;
        }
        System.out.println ();
    }

    @Override
    public String toString () {
        return new StringJoiner ( ", ", Node.class.getSimpleName () + "[", "]" )
                .add ( "data=" + data )
                .toString ();
    }
}