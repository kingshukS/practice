package com.kingshuk.tests;

import java.util.Arrays;

public class MinimumPlatforms {
    static int platformsCount(int arr[],int dep[])
    {
        int res = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1,j=0;
        int platforms = 1;
        while(i < arr.length && j< dep.length)
        {
            if(arr[i] <= dep[j])
            {
                i++;
                platforms++;
            }
            else if(arr[i] > dep[j])
            {
                j++;
                platforms--;
            }

            if(res<platforms)
            {
                res = platforms;
            }
        }
        return res;
    }
    public static void main(String args[])
    {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(platformsCount(arr,dep));

    }
}
