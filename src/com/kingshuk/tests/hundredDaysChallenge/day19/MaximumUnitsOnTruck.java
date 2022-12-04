package com.kingshuk.tests.hundredDaysChallenge.day19;

import java.util.Arrays;

/**
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long
 * as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck
 */
public class MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        for (int[] box : boxTypes) {
            count[box[1]] += box[0];
        }
        int boxes = 0;
        for (int units = 1000; units > 0; --units) {
            if (count[units] > 0) {
                int fitIn = Math.min(count[units], truckSize);
                boxes += units * fitIn;
                truckSize -= fitIn;
                if (truckSize == 0) {
                    return boxes;
                }
            }
        }
        return boxes;
    }

    public int maximumUnitsSort(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1],a[1]));
        int boxes = 0;
        for (int[] b : boxTypes) {
            if(b[0] >= truckSize)
            {
                boxes+=truckSize*b[1];
                return boxes;
            }else{
                boxes+=b[0] * b[1];
                truckSize-=b[0];
            }
        }
        return boxes;
    }
}
