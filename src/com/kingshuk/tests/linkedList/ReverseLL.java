package com.kingshuk.tests.linkedList;

public class ReverseLL {

    static Node1 revrseList ( Node1 head ) {
        Node1 prev = null;
        Node1 next = null;
        Node1 current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
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
        Node1 n = revrseList ( n1 );
        printList ( n );

    }
}
