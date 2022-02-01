package com.kingshuk.tests;

import java.util.Collections;
import java.util.PriorityQueue;

public class StreamOfIntegers {

    static void medianOfStream(int arr[])
    {
        double median = arr[0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(arr[0]);
        System.out.println(median);
        for(int i = 1;i<arr.length;i++)
        {
            int x = arr[i];
            if(minHeap.size()<maxHeap.size())
            {
                if(x<median)
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                }
                else
                {
                    minHeap.add(x);
                    median = (double)(maxHeap.peek()+minHeap.peek())/2;
                }

            }
            else if(minHeap.size()==maxHeap.size())
            {
                if(x<median)
                {
                    maxHeap.add(x);
                    median = (double)(maxHeap.peek());
                }
                else
                {
                    minHeap.add(x);
                    median = (double)(minHeap.peek());
                }
            }
            else
            {
                if(x>median) //when max heap is smaller
                {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                }
                else
                {
                    maxHeap.add(x);
                    median = (double)(maxHeap.peek()+minHeap.peek())/2;
                }
            }

            System.out.println(median);
        }
    }
    public static void main(String args[])
    {
        int arr[] = {5, 10, 15};
        medianOfStream(arr);
    }
}
