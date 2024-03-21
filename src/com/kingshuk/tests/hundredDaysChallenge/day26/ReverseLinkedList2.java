package com.kingshuk.tests.hundredDaysChallenge.day26;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class ReverseLinkedList2 {
    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 2 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 4 );
        head.next.next.next.next = new Node ( 5 );
        Node res = new ReverseLinkedList2 ().reverseBetween ( head, 2, 4 );
    }

    public Node reverseBetween ( Node head, int left, int right ) {
        Node sentinel = new Node ( 0 );
        sentinel.next = head;
        Node current = sentinel;
        int fastForward = left - 1;
        while (fastForward > 0) {
            current = current.next;
            fastForward--;
        }
        current.next = reverseFirstKNodes ( current.next, right - left + 1 );
        return sentinel.next;
    }

    private Node reverseFirstKNodes ( Node head, int k ) {
        Node current = head;
        Node prev = null;
        while (current != null && k > 0) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        head.next = current;
        return prev;
    }
}
