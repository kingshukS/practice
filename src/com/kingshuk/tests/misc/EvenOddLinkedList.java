package com.kingshuk.tests.misc;

public class EvenOddLinkedList {
    static Node head;

    public static void main ( String[] args ) {
        EvenOddLinkedList evenOddLinkedList = new EvenOddLinkedList ();
        Node head = new Node ( 1 );
        evenOddLinkedList.addToTheLast ( head );
        evenOddLinkedList.addToTheLast ( new Node ( 9 ) );
        evenOddLinkedList.addToTheLast ( new Node ( 6 ) );
        evenOddLinkedList.addToTheLast ( new Node ( 3 ) );
        evenOddLinkedList.addToTheLast ( new Node ( 56 ) );
        evenOddLinkedList.addToTheLast ( new Node ( 8 ) );
        evenOddLinkedList.printList ();
        evenOddLinkedList.segregateEveOdd ();
        evenOddLinkedList.printList ();
    }

    public void addToTheLast ( Node node ) {
        if ( head == null ) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

        }
    }

    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.println ( temp.data + " " );
            temp = temp.next;
        }
    }

    public void segregateEveOdd () {
        Node EvenStart = null;
        Node EvenEnd = null;
        Node OddStart = null;
        Node OddEnd = null;
        Node currentNode = head;


        while (currentNode != null) {
            int currNode = currentNode.data;
            if ( currNode % 2 == 0 ) //even case
            {
                if ( EvenStart == null ) {
                    EvenStart = currentNode;
                    EvenEnd = EvenStart;
                } else {
                    EvenEnd.next = currentNode;
                    EvenEnd = EvenEnd.next;
                }
            } else  //odd case
            {
                if ( OddStart == null ) {
                    OddStart = currentNode;
                    OddEnd = OddStart;
                } else {
                    OddEnd.next = currentNode;
                    OddEnd = OddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }
        if ( EvenStart == null || OddStart == null ) {
            return;
        }

        EvenEnd.next = OddStart;
        OddEnd.next = null;
        head = EvenStart;
    }

    static class Node {
        int data;
        Node next;

        Node ( int d ) {
            data = d;
            next = null;
        }
    }

}
