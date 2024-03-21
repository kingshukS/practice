package com.kingshuk.tests.hundredDaysChallenge.day9;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class PathSum {
    private boolean res = false;

    public boolean hasPathSum ( TreeNode root, int targetSum ) {
        if ( root == null )
            return false;
        int sum = 0;
        hasPathSum ( root, targetSum, sum );
        return res;
    }

    public void hasPathSum ( TreeNode root, int targetSum, int sum ) {
        if ( root != null ) {
            sum += root.key;
            if ( root.left == null && root.right == null && sum == targetSum )
                res = true;
            hasPathSum ( root.left, targetSum, sum );
            hasPathSum ( root.right, targetSum, sum );
        }
    }
}
