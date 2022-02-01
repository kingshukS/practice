package com.kingshuk.tests.AmazonQues;


import java.util.PriorityQueue;

public class FindMaxKElementInArray {

    public static void main(String[] args) {
        int[] array = new int[] {4, 10, 3, 5, 1,11,14,19};
        System.out.println(new FindMaxKElementInArray().findKthLargest(array, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println("Elements left in queue : "+pq);
        return pq.peek();
    }

}
