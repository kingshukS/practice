package com.kingshuk.tests.hundredDaysChallenge.day25;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class DeleteDuplicateNodes {

    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 2 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 3 );
        head.next.next.next.next = new Node ( 4 );

        Node res = new DeleteDuplicateNodes ().deleteDuplicates ( head );
    }

    public Node deleteDuplicates ( Node head ) {
        // sentinel
        Node sentinel = new Node ( 0 );
        sentinel.next = head;

        // predecessor = the last node 
        // before the sublist of duplicates
        Node pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if ( head.next != null && head.data == head.next.data ) {
                // move till the end of duplicates sublist
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }
}
