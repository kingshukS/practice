package com.kingshuk.tests.misc;

public class RemoveDuplicates {
    static void sortArray(int[] arr)
    {
        int i,j=0;
        for(i = 0;i<arr.length-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                arr[j] = arr[i];
                j++;
            }
        }
         arr[j] = arr[arr.length-1];

        for(int k = 0;k<j;k++)
        {
            System.out.print(arr[k]+" ");
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        sortArray(arr);
    }
}
