package com.kingshuk.tests.JustPractice;

public class LinkedLPalindrome {

    public static void main(String[] args) {
        LLNode n1 = new LLNode(5);
        n1.next = new LLNode(8);
        n1.next.next = new LLNode(7);
        n1.next.next.next = new LLNode(6);
        n1.next.next.next.next = new LLNode(5);
        n1.next.next.next.next.next = new LLNode(6);
        n1.next.next.next.next.next.next = new LLNode(7);
        n1.next.next.next.next.next.next.next = new LLNode(8);
        n1.next.next.next.next.next.next.next.next = new LLNode(5);
        System.out.println("is this list palindrome: "+palin(n1));

    }

    // static Node head; // head of list
    static LLNode slow_ptr, fast_ptr, second_half;
    static boolean res = true;

    static boolean palin(LLNode head) {
        slow_ptr = head;
        fast_ptr = head;
        LLNode prev_ptr = null;
        LLNode middle_node = null;
        second_half = null;
        while (fast_ptr != null && fast_ptr.next != null)//odd elements case
        {
            prev_ptr = slow_ptr;
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        //even elements case where fast ptr will not be null
        if (fast_ptr != null) {
            middle_node = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        second_half = slow_ptr;
        prev_ptr.next = null;

        reverse();
        res = compareLists(head, second_half);
        reverse();
        if (middle_node != null) {
            prev_ptr.next = middle_node;
            middle_node.next = second_half;
        } else
            prev_ptr.next = second_half;
        return res;
    }

    static void reverse() {
        LLNode current = second_half;
        LLNode prev = null;
        LLNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    static boolean compareLists(LLNode head1, LLNode head2) {
        LLNode temp1 = head1;
        LLNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }
        return temp1 == null && temp2 == null;

        /* Will reach here when one is NULL
           and other is not */
    }
}

