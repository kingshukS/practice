package com.kingshuk.tests.hundredDaysChallenge.day6;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

public class IntersectionNode {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(1);
        head.next.next = new Node(8);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node.printList(head);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = head.next;
        head2.next.next.next = head.next.next;
        head2.next.next.next.next = head.next.next.next;
        head2.next.next.next.next.next = head.next.next.next.next;
        Node.printList(head2);

        System.out.println("Middle Node: "+getIntersectionNode(head, head2));
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        Node c1 = headA, c2 = headB;
        int lenA = 0, lenB = 0;
        while(c1 != null)
        {
            lenA++;
            c1 = c1.next;
        }
        while(c2 != null)
        {
            lenB++;
            c2 = c2.next;
        }
        int diff = 0;
        if(lenA > lenB)
        {
            c1 = headA;
            c2 = headB;
            diff = lenA - lenB;
        }else{
            c1 = headB;
            c2 = headA;
            diff = lenB - lenA;
        }
        
        while(diff>0){
            c1 = c1.next;
            diff--;
        }

        while(c1!= null && c2!=null){
            if(c1 == c2)
                return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }
}