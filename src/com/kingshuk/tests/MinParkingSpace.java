package com.kingshuk.tests;

import java.util.Arrays;

public class MinParkingSpace {


    static int minParkingSpaces(int[][] parkingStartEndTimes)
    {
        int i=1,j=0;
        int minSlot = 1;
        int res = 0;
        int length = parkingStartEndTimes.length;
        int arr[] = new int[length];
        int dep[] = new int[length];
        for(int k  = 0;k<length;k++)
        {
            arr[k] = parkingStartEndTimes[k][0];
            dep[k] = parkingStartEndTimes[k][1];
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        while (i<length && j<length)
        {
            if(arr[i]<dep[j])
            {
                i++;
                minSlot++;
            }
            else{
                j++;
                minSlot--;
            }

            if(res<minSlot)
            {
                res = minSlot;
            }
        }

        return res;
    }
    public static void main(String args[])
    {
        int park[][] ={{0,10},
                       {5,20}};

        System.out.print(minParkingSpaces(park));

    }
}
