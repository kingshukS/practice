package com.kingshuk.tests.striver.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithXOR_K {
    public static int subarraysWithXorK(int []a, int k) {
        int xors = 0, diffXor = 0;
        int count = 0;
        Map<Integer, Integer> xorIndexMap = new HashMap<>();
        xorIndexMap.put(0, 1);

        for(int i = 0; i<a.length; i++)
        {
            xors^= a[i];
            diffXor = xors ^ k;

            count+=xorIndexMap.getOrDefault(diffXor, 0);
            xorIndexMap.put(xors, xorIndexMap.getOrDefault(xors, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9};
        int k = 5;
        System.out.println(subarraysWithXorK(A, k));
    }
}
