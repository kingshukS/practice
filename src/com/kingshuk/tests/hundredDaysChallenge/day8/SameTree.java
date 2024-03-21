package com.kingshuk.tests.hundredDaysChallenge.day8;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class SameTree {
    public boolean isSameTree ( TreeNode p, TreeNode q ) {
        if ( p == null && q == null )
            return true;
        if ( p == null || q == null )
            return false;
        if ( p.key != q.key )
            return false;
        return isSameTree ( p.left, q.left ) && isSameTree ( p.right, q.right );
    }
}
