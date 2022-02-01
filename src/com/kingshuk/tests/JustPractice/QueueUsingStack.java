package com.kingshuk.tests.JustPractice;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s = new Stack<>();
    public void enqueue(int data)
    {
        s.add(data);
    }
    public void dequeue()
    {
        if(s.size()<1)
        {
            System.out.println("Nothing to deque");
            return;
        }
        if(s.size()==1)
        {
            System.out.println(s.pop());
            return;
        }
        int data = s.pop();
        dequeue();
        s.push(data);
    }
    public static void main(String args[])
    {
        QueueUsingStack qus = new QueueUsingStack();
        qus.enqueue(5);
        qus.enqueue(15);
        qus.enqueue(25);
        qus.dequeue();
        qus.dequeue();
        qus.dequeue();
        qus.enqueue(115);
        qus.enqueue(75);
        qus.dequeue();
        qus.dequeue();
        qus.dequeue();

    }
}
