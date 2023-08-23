package com.kingshuk.tests.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class MinimumMultiplicationSteps {
    int minimumMultiplications(int[] arr, int start, int end) {

        Pair startingPair = new Pair(start, 0);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(startingPair);

        int mod = 100000;
        int[] steps = new int[mod];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[start] = 0;

        while(queue.isEmpty()){
            Pair pair = queue.poll();
            int num = pair.num;
            int step = pair.steps;

            for(int x : arr)
            {
                int res = (x * num) % mod;
                if(step + 1 < steps[res])
                {
                    steps[res] = step + 1;
                    if(res == end)
                        return steps[res];
                    queue.add(new Pair(res, steps[res]));
                }
            }
        }
        return -1;
    }

    class Pair{
        int num, steps;
        public Pair(int num, int steps) {
            this.num = num;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,5,7};
        System.out.println(new MinimumMultiplicationSteps().minimumMultiplications(arr, 3, 30));
    }
}