package com.kingshuk.tests.hundredDaysChallenge.day5;


public class RemoveElements {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(1);

        Node.printList(head);
        head = removeElements(head, 1);
        Node.printList(head);
    }

    private static Node removeElements(Node head, int val) {
        if(head == null)
            return head;
        Node dummy = new Node(Integer.MAX_VALUE);
        dummy.next = head;
        Node current = dummy;
        while(current.next != null)
        {
            if(current.next.data == val)
            {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return dummy.next;
    }
}
