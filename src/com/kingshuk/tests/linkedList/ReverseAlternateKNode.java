package com.kingshuk.tests.linkedList;

public class ReverseAlternateKNode {

    static Node1 reverseAlt ( Node1 head, int k ) {
        Node1 prev = null, next = null;
        Node1 current = head;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if ( head != null ) {
            head.next = current;
        }
        count = 0;
        if ( current != null && count < k - 1 ) {
            current = current.next;
            count++;
        }
        if ( current != null ) {
            current.next = reverseAlt ( current.next, k );
        }
        head = prev;
        return head;
    }

    static void printList ( Node1 head ) {
        while (head != null) {
            System.out.print ( head.data + " " );
            head = head.next;
        }
    }

    public static void main ( String[] args ) {
        Node1 n1 = new Node1 ( 9 );
        n1.next = new Node1 ( 8 );
        n1.next.next = new Node1 ( 7 );
        n1.next.next.next = new Node1 ( 6 );
        n1.next.next.next.next = new Node1 ( 5 );
        n1.next.next.next.next.next = new Node1 ( 4 );
        n1.next.next.next.next.next.next = new Node1 ( 3 );
        n1.next.next.next.next.next.next.next = new Node1 ( 2 );
        n1.next.next.next.next.next.next.next.next = new Node1 ( 1 );

        int k = 5;
        Node1 n = reverseAlt ( n1, k );
        printList ( n );

    }
}
