package com.kingshuk.tests.striver.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Approach:
 *
 * Initialize 4 variables:
 * cnt1 & cnt2 –  for tracking the counts of elements
 * el1 & el2 – for storing the majority of elements.
 * Traverse through the given array.
 * If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along
 * with increasing the cnt1 value by 1.
 * If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along
 * with increasing the cnt2 value by 1.
 * If the current element and el1 are the same increase the cnt1 by 1.
 * If the current element and el2 are the same increase the cnt2 by 1.
 * Other than all the above cases: decrease cnt1 and cnt2 by 1.
 * The integers present in el1 & el2 should be the result we are expecting. So, using another loop, we will
 * manually check their counts if they are greater than the floor(N/3).
 *
 * Intuition: If the array contains the majority of elements, their occurrence must be greater than the floor(N/3).
 * Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array.
 * So when we traverse through the array we try to keep track of the counts of elements and the elements themselves for which
 * we are tracking the counts.
 *
 * After traversing the whole array, we will check the elements stored in the variables. Then we need to check if the stored
 * elements are the majority elements or not by manually checking their counts.
 */
class MajorityElement2 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 1, 4, 2, 6};
        System.out.println(new MajorityElement2().majorityElement(nums));
    }
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0, e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int x : nums)
        {
            if(c1 == 0 && e2 != x)
            {
                e1 =x;
                c1 = 1;
            }else if(c2 == 0 && e1 != x)
            {
                e2 = x;
                c2 = 1;
            }else if(e1 == x)
            {
                c1++;
            }else if(e2 == x)
            {
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;

        for(int x : nums)
        {
            if(e1 == x)
            {
                c1++;
            }else if(e2 == x)
            {
                c2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(c1> n /3)
            list.add(e1);
        if(c2> n /3)
            list.add(e2);

        return list;
    }
}