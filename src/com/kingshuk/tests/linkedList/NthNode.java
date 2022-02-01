package com.kingshuk.tests.linkedList;

public class NthNode {

    static void nthNode(Node1 node,int k)
    {
        Node1 slow = node;
        Node1 fast = node;
        int count = 1;
        while(count<k)
        {
            fast = fast.next;
            count++;

        }
        System.out.println(fast.data);
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("The 3rd node from last in the linked list is : "+slow.data);
    }
    public static void main(String args[])
    {
        Node1 n1 = new Node1(9);
        n1.next = new Node1(8);
        n1.next.next = new Node1(7);
        n1.next.next.next = new Node1(6);
        n1.next.next.next.next = new Node1(5);
        n1.next.next.next.next.next = new Node1(4);
        nthNode(n1,3);
    }
}
