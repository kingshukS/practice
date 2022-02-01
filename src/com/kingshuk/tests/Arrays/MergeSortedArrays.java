package com.kingshuk.tests.Arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String args[])
    {
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};
        mergeArrays(arr1,arr2);
    }

    static void mergeArrays(int arr1[],int arr2[])
    {
        int size1 = arr1.length;
        int size2 = arr2.length;
        for(int i = size2-1;i>=0;i--)
        {
             /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j;
            int last = arr1[size1-1];
            for(j=size1-2;j>=0 && arr1[j] > arr2[i]  ;j--)
            {
                arr1[j+1] = arr1[j];
            }
            // If there was a greater element
            if(j != size1-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
        System.out.println("arrays after sorting "+ Arrays.toString(arr1)+ " "+Arrays.toString(arr2));
    }
}
