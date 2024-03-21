package com.kingshuk.tests.hundredDaysChallenge.day9;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class RangeSumBST {
    int rangeSum = 0;

    public int rangeSumBST ( TreeNode root, int low, int high ) {
        if ( root == null )
            return 0;
        if ( root.key < low )
            rangeSumBST ( root.right, low, high );
        else if ( root.key > high )
            rangeSumBST ( root.left, low, high );
        else {
            rangeSum += root.key;
            rangeSumBST ( root.left, low, high );
            rangeSumBST ( root.right, low, high );
        }
        return rangeSum;
    }
}
