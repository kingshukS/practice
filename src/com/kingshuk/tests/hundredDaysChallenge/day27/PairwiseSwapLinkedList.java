package com.kingshuk.tests.hundredDaysChallenge.day27;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class PairwiseSwapLinkedList {
    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 2 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 4 );
        head.next.next.next.next = new Node ( 5 );
        head.next.next.next.next.next = new Node ( 6 );
        Node res = new PairwiseSwapLinkedList ().swapPairs2 ( head );
    }

    public Node swapPairs ( Node head ) {
        if ( head == null || head.next == null )
            return head;
        Node newHead = head.next;
        swap ( head, head.next );
        return newHead;
    }

    public void swap ( Node prev, Node cur ) {
        Node next = cur.next;
        cur.next = prev;
        if ( next == null || next.next == null ) {
            prev.next = next;
            return;
        }
        prev.next = next.next;
        swap ( next, next.next );
    }

    public Node swapPairs2 ( Node head ) {
        if ( head == null || head.next == null )
            return head;
        Node prev = head;
        Node cur = head.next;
        head = head.next;
        while (true) {
            Node next = cur.next;
            cur.next = prev;
            if ( next == null || next.next == null ) {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            cur = prev.next;
        }
        return head;
    }

    public Node swapPairs3 ( Node head ) {
        if ( head == null || head.next == null )
            return head;

        Node next = head.next;
        Node recurTarget = next.next;
        head.next = swapPairs ( recurTarget );
        next.next = head;

        return next;
    }
}
