package com.kingshuk.tests.hundredDaysChallenge.day25;

import com.kingshuk.tests.hundredDaysChallenge.day5.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You are given the head of a linked list with n nodes.
 * <p>
 * For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
 * <p>
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
 */
public class NextGreaterNode {
    public int[] nextLargerNodes ( Node head ) {
        Node ptr = head;
        List<Integer> result = new ArrayList<> ();
        Stack<int[]> stack = new Stack<> ();
        int count = 0;
        while (ptr != null) {
            result.add ( 0 );
            while (! stack.isEmpty () && stack.peek ()[1] < ptr.data) {
                int[] res = stack.pop ();
                result.set ( res[0], ptr.data );
            }
            stack.add ( new int[]{ count++, ptr.data } );
            ptr = ptr.next;
        }
        return result.stream ().mapToInt ( i -> i ).toArray ();
    }
}
