package com.kingshuk.tests.linkedList;

public class EvenOddAggreagtion {
    public static void main ( String[] args ) {

        Node1 n1 = new Node1 ( 9 );
        n1.next = new Node1 ( 8 );
        n1.next.next = new Node1 ( 7 );
        n1.next.next.next = new Node1 ( 6 );
        n1.next.next.next.next = new Node1 ( 5 );
        n1.next.next.next.next.next = new Node1 ( 4 );
        n1.next.next.next.next.next.next = new Node1 ( 3 );
        n1.next.next.next.next.next.next.next = new Node1 ( 2 );
        n1.next.next.next.next.next.next.next.next = new Node1 ( 1 );

        EvenOddAggreagtion evenOddAggreagtion = new EvenOddAggreagtion ();
        evenOddAggreagtion.oddEveSegreg ( n1 );

    }

    void oddEveSegreg ( Node1 head ) {
        Node1 evenStart = null;
        Node1 evenEnd = null;
        Node1 oddStart = null;
        Node1 oddEnd = null;
        Node1 current = head;

        while (current != null) {
            int element = current.data;
            if ( element % 2 == 0 ) {
                if ( evenStart == null ) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if ( oddStart == null ) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }


            current = current.next;
        }
        if ( oddStart == null || evenStart == null )
            return;

        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
        Node1 temp = head;
        while (head != null) {
            System.out.print ( head.data + " " );
            head = head.next;
        }
    }
}
