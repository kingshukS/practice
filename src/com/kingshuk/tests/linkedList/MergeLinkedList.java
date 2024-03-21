package com.kingshuk.tests.linkedList;

public class MergeLinkedList {
    static Node headA;
    static Node headB;
    static Node head;

    public static void main ( String[] args ) {
        MergeLinkedList mergeLinkedList = new MergeLinkedList ();
        headA = new Node ( 5 );
        headA.next = new Node ( 15 );
        headA.next.next = new Node ( 25 );
        headA.next.next.next = new Node ( 35 );
        headA.next.next.next.next = new Node ( 45 );

        headB = new Node ( 7 );
        headB.next = new Node ( 14 );
        headB.next.next = new Node ( 17 );
        headB.next.next.next = new Node ( 28 );
        headB.next.next.next.next = new Node ( 33 );

        head = mergeLinkedList.sortedMerge ( headA, headB );
        mergeLinkedList.printList ();
    }

    Node sortedMerge ( Node headA, Node headB ) {
        Node dummyNode = new Node ( 0 );
        Node tail = dummyNode;
        while (true) {
            if ( headA == null ) {
                tail.next = headA;
                break;
            }
            if ( headB == null ) {
                tail.next = headB;
                break;
            }

            if ( headA.data <= headB.data ) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }

    void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.print ( temp.data + " " );
            temp = temp.next;
        }
        System.out.println ();
    }

    static class Node {
        int data;
        Node next;

        Node ( int data ) {
            this.data = data;
        }
    }

}
