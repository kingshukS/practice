package com.kingshuk.tests.linkedList;

public class LinkedListReversal {
    static Node head;

    public static void main ( String[] args ) {
        LinkedListReversal list = new LinkedListReversal ();
        head = new Node ( 85 );
        head.next = new Node ( 15 );
        head.next.next = new Node ( 4 );
        head.next.next.next = new Node ( 20 );
        System.out.println ( "Given Linked list" );
        list.printList ( head );
        head = list.reverse ( head );
        System.out.println ();
        System.out.println ( "Reversed linked list " );
        list.printList ( head );
    }

    Node reverse ( Node node ) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    void printList ( Node node ) {
        while (node != null) {
            System.out.print ( node.data + " " );
            node = node.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node ( int d ) {
            this.data = d;
            next = null;
        }
    }
}
