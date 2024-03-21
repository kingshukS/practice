package com.kingshuk.tests.Trees;

public class BurnABinaryTreeFromLeaf {
    private static int res = 0;

    public static int burnTime ( TreeNode root, int leaf, Distance dist ) {
        if ( root == null ) return 0;
        if ( root.data == leaf ) {
            dist.val = 0;
            return 1;
        }
        Distance lDist = new Distance ( - 1 ), rDist = new Distance ( - 1 );
        int lh = burnTime ( root.left, leaf, lDist );
        int rh = burnTime ( root.right, leaf, rDist );

        if ( lDist.val != - 1 ) {
            dist.val = lDist.val + 1;
            res = Math.max ( res, dist.val + rh );
        } else if ( rDist.val != - 1 ) {
            dist.val = rDist.val + 1;
            res = Math.max ( res, dist.val + lh );
        }
        return Math.max ( lh, rh ) + 1;
    }

    static class Distance {
        int val;

        Distance ( int d ) {
            val = d;
        }
    }
}
