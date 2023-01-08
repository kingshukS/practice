package com.kingshuk.tests.hundredDaysChallenge.day26;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node sentinel = new Node(0);
        Node result = sentinel;
        while(l1 != null || l2 != null || carry !=0){
            int num1 = l1 != null ? l1.data : 0;
            int num2 = l2 != null ? l2.data : 0;
            int sum = num1+num2+carry;
            Node node = new Node(sum%10);
            result.next = node;
            result = node;
            carry = sum / 10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return sentinel.next;
    }
}
