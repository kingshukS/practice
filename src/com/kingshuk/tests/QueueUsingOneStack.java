package com.kingshuk.tests;

import java.util.Stack;

public class QueueUsingOneStack {

    public static void main(String args[])
    {
        QueueProg queueUsingOneStack = new QueueProg();
        queueUsingOneStack.enqueue(10);
        queueUsingOneStack.enqueue(20);
        queueUsingOneStack.enqueue(30);
        queueUsingOneStack.enqueue(40);

        queueUsingOneStack.deque();
        queueUsingOneStack.deque();

        queueUsingOneStack.enqueue(50);
        queueUsingOneStack.enqueue(60);


        queueUsingOneStack.deque();
        queueUsingOneStack.deque();
        queueUsingOneStack.deque();
        queueUsingOneStack.deque();
        queueUsingOneStack.deque();
        queueUsingOneStack.deque();
        queueUsingOneStack.deque();



    }
}

   class QueueProg{
    Stack<Integer> stack = new Stack<Integer>();
    public void enqueue(int data){
        stack.add(data);
    }

    public void deque()
    {
        if(stack.size()<1)
        {
            System.out.println("The size of stack is less than 1");
            return;
        }
        if(stack.size()==1)
        {
            System.out.println(stack.pop());
            return;
        }
       int data = stack.pop();
        deque();
        stack.push(data);

    }
}
