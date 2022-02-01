package com.kingshuk.tests;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreams {

    static void findMedian(int arr[])
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double median = arr[0];
        maxHeap.add(arr[0]);
        System.out.println(median);
        for(int i = 1;i<arr.length;i++)
        {
            int x=arr[i] ;
            if(maxHeap.size()>minHeap.size())
            {

                if(median>x)
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                }
                else {
                    minHeap.add(x);
                    median = (double) (minHeap.peek()+maxHeap.peek())/2;
                }
            }
            else if(maxHeap.size()==minHeap.size())
            {
                if(median>x){
                    maxHeap.add(x);
                    median = (double)maxHeap.peek();
                }
                else
                {
                    minHeap.add(x);
                    median = (double)minHeap.peek();

                }
            }
            else
            {
                if(median>x)
                {
                    maxHeap.add(x);
                    median = (double) (minHeap.peek()+maxHeap.peek())/2;
                }
                else
                {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                }

            }
            System.out.println(median);
        }

    }
    public static void main(String args[])
    {
        int arr[] = {5, 15, 10, 20, 3};
        findMedian(arr);
    }
}
