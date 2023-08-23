package com.kingshuk.tests.misc;

public class TestTrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
        int profit = findMaximumWater(arr,n);
        System.out.println("Water Logged:"+profit);
    }

    private static int findMaximumWater(int[] arr, int n) {
        int water = 0;
        int track = 0;
        int p_value = arr[0];
        int p_index = 0;
        int i = 1;

        while(i<n){
            if(arr[i] < p_value)
            {
                water+=p_value - arr[i];
                track+=p_value - arr[i];
            }else{
                track = 0;
                p_index = i;
                p_value = arr[i];
            }
            i++;
        }

        if(p_index != n-1) {
            water -= track;
            p_value = arr[n - 1];
            i = n - 1;
            while (i >= p_index) {
                if (arr[i] < p_value) {
                    water += p_value - arr[i];
                } else {
                    p_value = arr[i];
                }
                i--;
            }
        }
        return water;
    }
}
