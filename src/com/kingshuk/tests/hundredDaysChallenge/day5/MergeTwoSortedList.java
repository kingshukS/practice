package com.kingshuk.tests.hundredDaysChallenge.day5;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);

        Node head = mergeTwoLists(head1, head2);
        Node.printList(head);
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        Node list3 = null, c1 = list1, c2 = list2, c3 = null;
        if(c1.data<=c2.data)
        {
            list3 = c1;
            c3 = c1;
            c1 = c1.next;
        }else{
            list3 = c2;
            c3 = c2;
            c2 = c2.next;
        }

        while(c1 != null && c2 != null){
            if(c1.data<=c2.data)
            {
                c3.next = c1;
                c3 = c1;
                c1 = c1.next;
            }else{
                c3.next = c2;
                c3 = c2;
                c2 = c2.next;
            }
        }
        while(c1 != null){
            c3.next = c1;
            c3 = c1;
            c1 = c1.next;
        }

        while(c2 != null){
            c3.next = c2;
            c3 = c2;
            c2 = c2.next;
        }
        return list3;
    }
}
