package com.kingshuk.tests.misc;

public class TestSubarrayGivenSumNonNegative {
    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 33;
        subArraySum(arr, n, sum);
    }

    private static void subArraySum(int[] arr, int n, int sum) {
        int cur_sum = arr[0];
        int start = 0;
        for(int i = 1; i<=n; i++){
            while(start<i && cur_sum>sum)
            {
                cur_sum -=arr[start++];
            }
            if(cur_sum==sum)
            {
                System.out.println("Start:"+(start)+" End:"+(i-1));
                return;
            }
            if(i<n)
                cur_sum+=arr[i];
        }
        System.out.println("No Subarray Found");
        return;
    }
}
