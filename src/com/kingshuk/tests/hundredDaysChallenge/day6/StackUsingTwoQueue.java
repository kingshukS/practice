package com.kingshuk.tests.hundredDaysChallenge.day6;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    Queue<Integer> mainQueue;
    Queue<Integer> tempQueue;

    public StackUsingTwoQueue() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingTwoQueue stack = new StackUsingTwoQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    public void push(int x) {
        mainQueue.add(x);
    }

    public int pop() {
        if (mainQueue.isEmpty())
            return -1;
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.poll());
        }
        int data = mainQueue.poll();
        mainQueue = tempQueue;
        tempQueue = new LinkedList<>();
        return data;
    }

    public int peek() {
        if (mainQueue.isEmpty())
            return -1;
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.poll());
        }
        int data = mainQueue.poll();
        mainQueue = tempQueue;
        mainQueue.add(data);
        tempQueue = new LinkedList<>();
        return data;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
