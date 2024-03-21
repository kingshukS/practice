package com.kingshuk.tests.hundredDaysChallenge.day5;


public class ReverseLinkedList {

    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 2 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 4 );
        head.next.next.next.next = new Node ( 5 );
        Node.printList ( head );
        head = reverseList ( head );
        Node.printList ( head );
        head = reverseListRecursive ( head );
        Node.printList ( head );
    }

    private static Node reverseList ( Node head ) {
        if ( head == null || head.next == null )
            return head;
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static Node reverseListRecursive ( Node head ) {
        if ( head == null || head.next == null )
            return head;
        Node rest = reverseListRecursive ( head.next );
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
