package com.kingshuk.tests.hundredDaysChallenge.day16;

import java.util.PriorityQueue;

class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int n : nums) pq.offer(n);
        while (pq.size() > k) pq.poll();
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}