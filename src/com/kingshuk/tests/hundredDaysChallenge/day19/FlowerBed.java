package com.kingshuk.tests.hundredDaysChallenge.day19;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers
 * can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */
public class FlowerBed {
    public boolean canPlaceFlowers ( int[] flowerbed, int n ) {
        int count = 0;
        for ( int i = 0; i < flowerbed.length && count < n; i++ ) {
            if ( flowerbed[i] == 0 ) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                int next = ( i == flowerbed.length - 1 ) ? 0 : flowerbed[i + 1];
                int prev = ( i == 0 ) ? 0 : flowerbed[i - 1];
                if ( next == 0 && prev == 0 ) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count == n;
    }
}
