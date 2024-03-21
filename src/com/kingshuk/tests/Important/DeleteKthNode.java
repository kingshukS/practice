package com.kingshuk.tests.Important;

public class DeleteKthNode {
    static ListNode removeKthNode ( ListNode head, int k ) {
        ListNode ptr = head;
        ListNode prev_ptr = null;
        int count = 0;
        if ( head == null )
            return null;

        if ( k == 1 ) {
            return head;
        }
        while (ptr != null) {

            count++;
            if ( count == k ) {
                prev_ptr.next = ptr.next;
                count = 0;
            }
            if ( count != 0 )
                prev_ptr = ptr;

            ptr = prev_ptr.next;
        }
        return head;
    }

    static void displayList ( ListNode head ) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print ( temp.data + " " );
            temp = temp.next;
        }
    }

    public static void main ( String[] args ) {
        ListNode head = new ListNode ( 5 );
        head.next = new ListNode ( 3 );
        head.next.next = new ListNode ( 1 );
        head.next.next.next = new ListNode ( 8 );
        head.next.next.next.next = new ListNode ( 6 );
        head.next.next.next.next.next = new ListNode ( 0 );
        head.next.next.next.next.next.next = new ListNode ( 9 );
        head.next.next.next.next.next.next.next = new ListNode ( 4 );
        head.next.next.next.next.next.next.next.next = new ListNode ( 7 );
        int k = 3;
        head = removeKthNode ( head, k );
        displayList ( head );
    }
}

class ListNode {

    int data;
    ListNode next;

    ListNode ( int data ) {
        this.data = data;
    }
}
