package com.kingshuk.tests.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class StreamMedian {

    static void findMedian(int[] arr)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double median = arr[0];
        maxHeap.add(arr[0]);
        for(int i = 1;i<arr.length;i++)
        {

            if(maxHeap.size()>minHeap.size())
            {
                if(median>arr[i])
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(arr[i]);
                }
                else {
                    minHeap.add(arr[i]);
                    median = (double) (minHeap.peek()+maxHeap.peek())/2;
                }
            }
            else if(maxHeap.size()==minHeap.size())
            {
                if(median>arr[i]){
                    maxHeap.add(arr[i]);
                    median = (double)maxHeap.peek();
                }
                else
                {
                    minHeap.add(arr[i]);
                    median = (double)minHeap.peek();

                }
            }
            else
            {
                if(median>arr[i])
                {
                    maxHeap.add(arr[i]);
                    median = (double) (minHeap.peek()+maxHeap.peek())/2;
                }
                else
                {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(arr[i]);
                }

            }
            System.out.println(median);
        }

    }
    public static void main(String args)
    {
        int[] arr = {5, 15, 10, 20, 3};
        findMedian(arr);
    }
}
