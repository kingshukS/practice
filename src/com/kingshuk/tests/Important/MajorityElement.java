package com.kingshuk.tests.Important;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    static void majorityEle(int arr[])
    {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i =0;i<arr.length;i++)
        {
            if(hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]) +1;
                if (count > arr.length /2) {
                    System.out.println("Majority found :- " + arr[i]);
                    return;
                } else
                    hm.put(arr[i], count);
            }
            else
            {
                hm.put(arr[i],1);
            }

        }
        System.out.println(" No Majority element");

    }
    public static void main(String args[])
    {
        int arr[]={3 ,1 ,3 ,3 ,2};
        majorityEle(arr);
    }
}
