package com.kingshuk.tests.misc;

public class TestPageAllocationBinarySearch {
    public static void main(String[] args) {

        int[] arr = {10,20,10,30};// pages
        int m = 2; //No. of students
        System.out.println("Minimum number of pages = " +findPages(arr, arr.length, m));
    }

    private static int findPages(int[] arr, int n, int m) {
        int mx = Integer.MIN_VALUE,sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
            mx = Math.max(mx,arr[i]);
        }
        int low = mx, high = sum, ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isFeasible(arr,mid,m))
            {
                ans = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isFeasible(int[] arr, int mid, int m) {
        int n = arr.length;
        int req = 1;
        int sum = 0;
        for(int i = 0; i<n; i++){
            if(sum+arr[i]>mid)
            {
                req++;
                sum = arr[i];
            }else{
                sum+=arr[i];
            }
        }
        return req<=m;
    }
}
