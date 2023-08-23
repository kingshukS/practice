package com.kingshuk.tests.misc;

public class TestMaximuWaterBetweenTwoBuildings {
    public static void main(String[] args) {
        int height[] = {2,1,3,4,6,5};
        int n = height.length;
        int water = findMaxWaterBetweenBuildings(height,n);
        System.out.println("Maxumum water = "+water);
    }

    private static int findMaxWaterBetweenBuildings(int[] height, int n) {
        int right = n-1;
        int left = 0;
        int maxWater = 0;
        while(right-left>1)
        {
            int water = (right-left-1) * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater,water);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
