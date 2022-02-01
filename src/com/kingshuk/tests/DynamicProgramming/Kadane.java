package com.kingshuk.tests.DynamicProgramming;

public class Kadane {

    static void maxSum(int arr[])
    {
        int sumTillNow = 0;
        int maxSum = 0;
        int start=0,s=0,end=0;
        for(int i =0;i<arr.length;i++)
        {
            sumTillNow += arr[i];

            if(maxSum<sumTillNow)
            {
                maxSum = sumTillNow;
                start = s;
                end = i;
            }

            if(sumTillNow<0)
            {
                sumTillNow = 0;
                s = i+1;
            }
        }
        System.out.print("Max sum is "+maxSum + " starting index : "+start+" end index : "+ end);
    }
    public static void main(String args[])
    {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxSum(arr);
    }
}
