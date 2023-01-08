package com.kingshuk.tests.hundredDaysChallenge.day26;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node cur = head;
        while(cur!=null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            if(cur.next != null){
                cur.next.random = cur.random != null ? cur.random.next : null;
            }
            cur = cur.next.next;
        }

        Node original = head, copy = head.next, tmp = copy;
        while(original != null){
            original.next = original.next.next;
            copy.next = copy.next != null ? copy.next.next: null;
            original = original.next;
            copy = copy.next;
        }
        return tmp;
    }
}
