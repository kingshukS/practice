package com.kingshuk.tests.hundredDaysChallenge.day25;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEnd {
    public Node removeNthFromEnd(Node head, int n) {
        if(head==null||head.next==null) return null;
        Node lead = head;
        Node fellow = head;
        n--;
        for(int i=0;i<n;i++) lead = lead.next;
        if(lead==null) return head.next;
        if(lead.next==null){
            return head.next;
        }
        while(lead.next.next!=null){
            lead=lead.next;
            fellow=fellow.next;
        }
        fellow.next=fellow.next.next;
        return head;
    }

    public Node removeNthFromEnd2(Node head, int n) {
        int count = 0;
        Node current = head;
        while(current!=null){
            current = current.next;
            count++;
        }
        if(count<n)
            return head;
        if(count == n){
            head = head.next;
            return head;
        }
        count = count - n;
        int c = 1;
        current = head;
        while(c<count){
            current = current.next;
            c++;
        }
        current.next = current.next.next;
        return head;
    }

    public Node removeNthFromEnd3(Node head, int n) {
        Node s = head, f = head;
        while(n>0){
            f = f.next;
            n--;
        }
        if(f == null)
            return s.next;
        while(f.next != null)
        {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return head;
    }
}
