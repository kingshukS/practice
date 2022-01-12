package com.kingshuk.tests.sorting;

import java.util.Arrays;
// With duplicate elements
// With writes count
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 8, 3, 0, 1, 7, 2};
        applyCycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void applyCycleSort(int[] arr) {
        int n = arr.length;
        int writes = 0;
        for(int cs = 0; cs<n-1; cs++)
        {
            int element = arr[cs];
            int pos = cs;
            for(int i = cs+1; i<n; i++)
            {
                if(element > arr[i])
                    pos++;
            }
            if(pos == cs)
                continue;
            while(arr[pos] == element)
                pos++;
            if(pos != cs)
            {
                int temp = arr[pos];
                arr[pos] = element;
                element = temp;
                writes++;
            }
            while(pos != cs)
            {
                pos = cs;
                for(int i = cs+1; i<n; i++)
                {
                    if(element > arr[i])
                        pos++;
                }
                while(arr[pos] == element)
                    pos++;
                if(element != arr[pos])
                {
                    int temp = arr[pos];
                    arr[pos] = element;
                    element = temp;
                    writes++;
                }
            }
        }
        System.out.println("Total writes:"+writes);
    }
}
