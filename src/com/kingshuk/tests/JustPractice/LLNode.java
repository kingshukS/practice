package com.kingshuk.tests.JustPractice;

public class LLNode {
    LLNode next;
    int data;

    public LLNode ( int data ) {
        this.data = data;
    }

    public LLNode getNext () {
        return next;
    }

    public void setNext ( LLNode next ) {
        this.next = next;
    }

    public int getData () {
        return data;
    }

    public void setData ( int data ) {
        this.data = data;
    }


}
