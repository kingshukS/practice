package com.kingshuk.tests.JustPractice;

public class TrappingRainWater {

    static int waterCapacity(int[] arr)
    {
        int prev_index = 0;
        int prev = arr[0];
        int water=0;
        int temp = 0;
        int size= arr.length-1;

        for(int i = 1;i<=size;i++)
        {
            if(arr[i]>=prev)
            {
                prev = arr[i];
                prev_index=i;

                temp = 0;
            }
            else
            {
                water += prev - arr[i];
                temp += prev -arr[i];
            }
        }

        if(prev_index<size)
        {
            water -= temp;
            prev = arr[size];
            for(int i = size; i>=prev_index ;i--)
            {
                if (arr[i] >= prev) {
                    prev = arr[i];
                }
                else {
                    water += prev - arr[i];
                }
            }
        }

        return water;
    }
    public static void main(String[] args)
    {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(waterCapacity(arr));
    }
}
