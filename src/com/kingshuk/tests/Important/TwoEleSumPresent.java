package com.kingshuk.tests.Important;

import java.util.HashSet;

public class TwoEleSumPresent {


        static void isSumPres(int arr[],int sum)
        {
            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0;i<arr.length;i++)
            {
                int temp = sum-arr[i];
                if(hs.contains(temp))
                {
                    System.out.print("The sum is present of "+arr[i]+" and "+temp);
                }
                hs.add(arr[i]);
            }
        }
        public static void main(String args[])
        {
            int arr[] = { 1, 4, 5, 6, 10, 8 };
            int sum = 9;
            isSumPres(arr,sum);


        }
}
