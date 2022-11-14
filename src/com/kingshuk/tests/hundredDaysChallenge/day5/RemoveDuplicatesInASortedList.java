package com.kingshuk.tests.hundredDaysChallenge.day5;

public class RemoveDuplicatesInASortedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head = deleteDuplicates(head);
        Node.printList(head);
    }

    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null)
            return head;
        Node dummy = new Node(Integer.MAX_VALUE);
        dummy.next = head;
        Node current = dummy;
        while(current != null && current.next != null){
            if(current.data == current.next.data)
            {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return dummy.next;
    }
}
