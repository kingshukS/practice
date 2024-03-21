package com.kingshuk.tests.hundredDaysChallenge.day6;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class DetectCycle {
    public static void main ( String[] args ) {
        Node head = new Node ( 4 );
        head.next = new Node ( 1 );
        head.next.next = new Node ( 8 );
        head.next.next.next = new Node ( 4 );
        head.next.next.next.next = new Node ( 5 );
        head.next.next.next.next.next = new Node ( 5 );
        boolean hasCycle = hasCycle ( head );
        System.out.println ( "Has cycle: " + hasCycle );
    }

    public static boolean hasCycle ( Node head ) {
        if ( head == null )
            return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast )
                return true;
        }
        return false;
    }
}
