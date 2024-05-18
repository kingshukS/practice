package com.kingshuk.tests.striver.arrays;

import java.util.Arrays;

public class MaxFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 3};
        int k = 5;
        System.out.println("Max freq possible: " + maxFrequency2(arr, k));
    }

    public static int maxFrequency2(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int len = max-min+1;
        int[] count = new int[len];

        for(int num : nums){
            count[num-min]++;
        }
        int start=0, sum=0,ans=0,cnt=0,startCnt=count[0];
        for(int i=0;i<len;++i){
            sum+=cnt;
            cnt+=count[i];
            while(sum>k){
                while(startCnt==0) startCnt = count[++start];
                sum-=i-start;
                startCnt--;
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    private static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0, right = 0;
        long total = 0, res = 0L;

        while (right < arr.length) {
            total += arr[right];
            while (total + k < arr[right] * (right - left + 1L)) {
                total -= arr[left++];
            }
            res = Math.max(res, right - left + 1L);
            right++;
        }
        return (int) res;
    }
}
