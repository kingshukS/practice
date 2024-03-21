package com.kingshuk.tests.hundredDaysChallenge.day26;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class AddTwoNumbers2 {
    public static void main ( String[] args ) {
        Node head1 = new Node ( 9 );
        head1.next = new Node ( 9 );
        head1.next.next = new Node ( 9 );
        Node head2 = new Node ( 1 );
        new AddTwoNumbers2 ().addTwoNumbers ( head1, head2 );
    }

    public Node addTwoNumbers ( Node l1, Node l2 ) {
        Node start1 = new Node ( 0 );
        start1.next = l1;
        Node start2 = new Node ( 0 );
        start2.next = l2;
        addPrecedingZeroes ( start1, start2 );
        Node sentinel = new Node ( 0 );
        Node result = sentinel;
        if ( sumOfLL ( start1.next, start2.next, result ) == 1 ) {
            Node node = new Node ( 1 );
            node.next = result.next;
            result.next = node;
        }
        return result.next;
    }

    private int sumOfLL ( Node start1, Node start2, Node result ) {
        if ( start1 == null )
            return 0;
        int sum = start1.data + start2.data + sumOfLL ( start1.next, start2.next, result );
        Node node = new Node ( sum % 10 );
        node.next = result.next;
        result.next = node;
        return sum / 10;
    }

    public void addPrecedingZeroes ( Node start1, Node start2 ) {
        Node cur1 = start1;
        Node cur2 = start2;
        while (cur1 != null && cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if ( cur1 == null && cur2 != null ) {
            while (cur2 != null) {
                Node dummy = new Node ( 0 );
                dummy.next = start1.next;
                start1.next = dummy;
                cur2 = cur2.next;
            }
        } else if ( cur1 != null && cur2 == null ) {
            while (cur1 != null) {
                Node dummy = new Node ( 0 );
                dummy.next = start2.next;
                start2.next = dummy;
                cur1 = cur1.next;
            }
        }
    }
}
