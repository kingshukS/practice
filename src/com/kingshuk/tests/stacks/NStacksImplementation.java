package com.kingshuk.tests.stacks;

/**
 * N Stacks implementation in an array
 */
public class NStacksImplementation {
    private final int[] arr;
    private final int[] top;
    private final int[] next;
    private int freeSlot;

    /**
     * Initialize top[] and next[]
     * top[] determines top element's index of the k stacks
     * next[] determines two things based on the scenario: a> If arr[i] contains an element of any stack then the next lower element
     * i.e. the element below teh top b> If arr[i] doesn't contain any element then the next free slot of i
     * freeSlot determines index of the next free slot available
     *
     * @param n size of the array
     * @param k number of the stacks implemented in the array
     */
    public NStacksImplementation ( int n, int k ) {
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        freeSlot = 0;
        for ( int i = 0; i < k; i++ ) {
            top[i] = - 1;
        }
        for ( int i = 0; i < n - 1; i++ ) {
            next[i] = i + 1;
        }
        next[n - 1] = - 1;
    }

    /**
     * Push the data in kth stack
     *
     * @param k    kth stack
     * @param data data to be inserted
     * @return true if the data is successfully inserted, else false
     */
    public boolean push ( int k, int data ) {
        if ( freeSlot == - 1 )
            return false;
        int index = freeSlot;
        freeSlot = next[index];
        arr[index] = data;
        next[index] = top[k - 1];
        top[k - 1] = index;
        return true;
    }

    /**
     * Pop an element from the kth stack
     *
     * @param k kth stack
     * @return popped element from the kth stack. If the stack is empty, returns {@link Integer#MIN_VALUE}
     */
    public int pop ( int k ) {
        if ( top[k - 1] == - 1 )
            return Integer.MIN_VALUE;
        int index = top[k - 1];
        top[k - 1] = next[index];
        next[index] = freeSlot;
        freeSlot = index;
        return arr[index];
    }
}
