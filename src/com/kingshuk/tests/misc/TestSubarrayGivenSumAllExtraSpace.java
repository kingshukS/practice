package com.kingshuk.tests.misc;

import java.util.HashMap;
import java.util.Map;

public class TestSubarrayGivenSumAllExtraSpace {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int n = arr.length;
        int sum = -22;
        subArraySum(arr, n, sum);
    }

    private static void subArraySum(int[] arr, int n, int sum) {
        int cur_sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i<n; i++)
        {
            cur_sum += arr[i];
            if(cur_sum == sum)
            {
                System.out.println("Start:"+0+" End:"+i);
                return;
            }
            if(map.containsKey(cur_sum-sum))
            {
                System.out.println("Start:"+(map.get(cur_sum-sum)+1)+" End:"+i);
                return;
            }
            map.put(cur_sum,i);
        }
        System.out.println("No Subarray");
        return;
    }
}
