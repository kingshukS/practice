package com.kingshuk.tests.sorting;

class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {1,2,3}));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n)
        {
            int element = nums[i];
            int index = element - 1;
            while(index>= 0 && index<= n-1 && nums[index] != nums[i])
            {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index = nums[i] - 1;
            }
            i++;
        }
        for(int j = 0; j<n; j++)
        {
            if(nums[j] != j+1)
                return j+1;
        }
        return n+1;
    }
}