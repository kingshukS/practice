package com.kingshuk.tests.hundredDaysChallenge.day4;

class NumArrayRangeQuery {

    private final int[] prefixSum;

    public NumArrayRangeQuery ( int[] nums ) {
        prefixSum = nums;
        for ( int i = 1; i < prefixSum.length; i++ ) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    public static void main ( String[] args ) {
        int[] nums = { - 2, 0, 3, - 5, 2, - 1 };
        NumArrayRangeQuery numArrayRangeQuery = new NumArrayRangeQuery ( nums );
        System.out.println ( numArrayRangeQuery.sumRange ( 0, 2 ) );
        System.out.println ( numArrayRangeQuery.sumRange ( 2, 5 ) );
        System.out.println ( numArrayRangeQuery.sumRange ( 0, 5 ) );
    }

    public int sumRange ( int left, int right ) {
        if ( left == 0 )
            return prefixSum[right];
        else
            return prefixSum[right] - prefixSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */