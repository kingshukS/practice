package com.kingshuk.tests.stacks;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyStack {
    private int[] arr;
    private int counter;
    private int max_size;

    public MyStack(int max_size) {
        this.max_size = max_size;
        arr = new int[max_size];
        counter = 0;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public void push(int data){
        if(counter == max_size){
            System.err.println("Overflow condition reached!!");
            return;
        }
        arr[counter++] = data;
    }

    public int peek(){
        if(counter == 0){
            System.err.println("Underflow condition reached!!");
            return Integer.MIN_VALUE;
        }
        return arr[counter-1];
    }

    public int pop(){
        if(counter == 0){
            System.err.println("Underflow condition reached!!");
            return Integer.MIN_VALUE;
        }
        return arr[--counter];
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyStack.class.getSimpleName() + "[", "]")
                .add("arr=" + Arrays.toString(arr))
                .toString();
    }
}
