package com.kingshuk.tests.JustPractice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KlargestElement {
    static int kLargest(int arr[],int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0;i<arr.length;i++)
        {
            pq.offer(arr[i]);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }
          // System.out.print(pq + " ");
        return pq.peek();
    }
    public static void main(String args[])
    {
        int arr[] = { 1, 23, 12, 9,
                30, 2, 50 };
        int k = 2;
        System.out.print(kLargest(arr,k));
    }
}
