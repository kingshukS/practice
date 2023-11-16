package com.kingshuk.tests.JustPractice;

public class Segregate01s {
    static void segregate(int[] arr)
    {
        int start = 0,end = arr.length-1;
        while(start<end)
        {
            while(arr[start] == 0)
            {
                start++;
            }

            while(arr[end] == 1)
            {
                end--;
            }

           if(start<=end) {
                arr[start++] = 0;
                arr[end--] = 1;
          }
        }
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args)
    {
      //  int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int[] arr = {0,1,0,0,1,1,1,0,1};

        segregate(arr);
    }
}
