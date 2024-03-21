package com.kingshuk.tests.linkedList;

public class LLmiddlepoint {

    static boolean loopExist ( Node1 head ) {
        Node1 slow = head;
        Node1 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if ( fast == slow ) {
                return true;
            }
        }
        return false;
    }

    public static void main ( String[] agrs ) {
        Node1 n1 = new Node1 ( 10 );
        Node1 n2 = new Node1 ( 20 );
        Node1 n3 = new Node1 ( 30 );
        Node1 n4 = new Node1 ( 40 );
        Node1 n5 = new Node1 ( 50 );
        Node1 n6 = new Node1 ( 20 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n2;

        boolean loop = loopExist ( n1 );
        if ( loop ) {
            System.out.print ( "Loop present" );
        } else {
            System.out.print ( "Loop not present" );
        }
    }
}

