package com.kingshuk.tests.linkedList;

public class ReverseKNodes {

    static Node1 revrseList1(Node1 head,int k)
    {
        Node1 next = null;
        Node1 prev = null;
        Node1 current = head;
        int count = 0;
        while(current!=null && count<k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count ++;
        }

        if(next!=null)
        {
            head.next = revrseList1(next,k);
        }

        return prev;
    }
    static void printList(Node1 head)
    {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    public static void main(String[] args)
    {
        Node1 n1 = new Node1(9);
        n1.next = new Node1(8);
        n1.next.next = new Node1(7);
        n1.next.next.next = new Node1(6);
        n1.next.next.next.next = new Node1(5);
        n1.next.next.next.next.next = new Node1(4);
        n1.next.next.next.next.next.next = new Node1(3);
        n1.next.next.next.next.next.next.next = new Node1(2);
        n1.next.next.next.next.next.next.next.next = new Node1(1);

        int k = 5;
        Node1 n = revrseList1(n1,k);
        printList(n);

    }
}
