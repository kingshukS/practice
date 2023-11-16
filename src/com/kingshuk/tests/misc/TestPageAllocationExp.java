package com.kingshuk.tests.misc;

public class TestPageAllocationExp {
    public static void main(String[] args) {

        int[] arr = {12, 34, 67, 90};// pages
        int m = 2; //No. of students
        System.out.println("Minimum number of pages = " +findPages(arr, arr.length, m));
    }

    private static int findPages(int[] arr, int n, int m) {
        if(n==1)
            return arr[0];
        if(m==1)
            return findSum(arr,0,n-1);
        int res = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            res = Math.min(res,Math.max(findPages(arr,i,m-1),findSum(arr,i,n-1)));
        }
        return res;
    }

    private static int findSum(int[] arr, int s, int e) {
        int sum = 0;
        for(int i = s; i<=e;i++)
            sum+= arr[i];
        return sum;
    }

}
