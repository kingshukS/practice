package com.kingshuk.tests.hundredDaysChallenge.day24;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
 * return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each,
 * and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0, high = citations.length-1, mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(citations[mid] == n-mid)
                return n-mid;
            else if(citations[mid]>n-mid)
                high = mid-1;
            else
                low = mid+1;
        }
        return n-low;
    }
}
