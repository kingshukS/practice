package com.kingshuk.tests;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueues {
    Queue<Integer> q = new LinkedList<>();
    public void push(int data)
    {
        q.add(data);
        int size = q.size();
        while(size>1)
        {
            q.add(q.remove());
            size--;
        }
    }
    public void pop()
    {
       if(q.isEmpty())
       {
           System.out.println("No element preset");
       }
       else
           q.poll();
    }
    public static void main(String args[])
    {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(5);
        stackUsingQueues.push(15);
        stackUsingQueues.push(50);
        stackUsingQueues.pop();
        stackUsingQueues.pop();
        stackUsingQueues.push(10);
        stackUsingQueues.push(70);
        stackUsingQueues.pop();
        stackUsingQueues.pop();

        System.out.println(stackUsingQueues.q);
    }
}
