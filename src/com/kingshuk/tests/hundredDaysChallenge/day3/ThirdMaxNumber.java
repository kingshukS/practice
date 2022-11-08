package com.kingshuk.tests.hundredDaysChallenge.day3;

/**
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist,
 * return the maximum number.
 */
public class ThirdMaxNumber {
    public static void main(String[] args) {
        int[] array = {2,2,3,1};
        int thirdMaxNumber = findThirdMaxNumber(array);
        System.out.println("Third Maximum Number: "+thirdMaxNumber);
    }

    private static int findThirdMaxNumber(int[] array) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for(Integer n : array){
            if(n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if(max1 == null || n>max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(max2 == null || n>max2){
                max3 = max2;
                max2 = n;
            }else if(max3 == null || n>max3){
                max3 = n;
            }
        }
        return max3==null?max1:max3;
    }
}
