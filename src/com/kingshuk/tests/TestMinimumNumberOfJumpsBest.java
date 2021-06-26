package com.kingshuk.tests;

public class TestMinimumNumberOfJumpsBest {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 1, 0, 9 };
        int size = arr.length;
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, size));
    }

    private static int minJumps(int[] arr, int size) {
        int jumps = 1;
        int maxReach = arr[0];
        int steps = arr[0];
        for(int i = 1; i<size; i++)
        {
            if(i == size-1)
                return jumps;
            maxReach = Math.max(maxReach,i+arr[i]);
            steps --;
            if(steps == 0)
            {
                jumps++;
                steps = maxReach - i;
                if(steps <= 0)
                    return -1;
            }
        }
        return jumps;
    }
}
