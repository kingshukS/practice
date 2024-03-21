package com.kingshuk.tests.hundredDaysChallenge.day27;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class PartitionList {
    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 4 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 2 );
        head.next.next.next.next = new Node ( 1 );
        head.next.next.next.next.next = new Node ( 6 );
        head.next.next.next.next.next.next = new Node ( 1 );
        Node res = new PartitionList ().partition ( head, 4 );
    }

    public Node partition ( Node head, int x ) {
        if ( head == null || head.next == null )
            return head;
        Node greaterHead = new Node ( 0 );
        Node gptr = greaterHead;
        Node smallerHead = new Node ( 0 );
        Node sptr = smallerHead;
        Node ptr = head;
        while (ptr != null) {
            if ( ptr.data < x ) {
                sptr.next = ptr;
                sptr = ptr;
                ptr = ptr.next;
            } else {
                gptr.next = ptr;
                gptr = ptr;
                ptr = ptr.next;
                gptr.next = null;
            }
        }
        sptr.next = greaterHead.next;
        return smallerHead.next;
    }
}
