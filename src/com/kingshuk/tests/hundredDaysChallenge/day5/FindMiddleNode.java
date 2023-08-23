package com.kingshuk.tests.hundredDaysChallenge.day5;

public class FindMiddleNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node.printList(head);
        Node middle = middleNode(head);
        System.out.println("Middle Node: "+middle);
    }

    public static Node middleNode(Node head) {
        if(head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
