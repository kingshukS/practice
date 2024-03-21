package com.kingshuk.tests.Trees;

public class BSTTwoSum {
    public boolean findTarget ( TreeNode root, int k ) {
        if ( root == null ) return false;

        BSTIteratorReverseSupport left = new BSTIteratorReverseSupport ( root, false );
        BSTIteratorReverseSupport right = new BSTIteratorReverseSupport ( root, true );

        int i = left.next ();
        int j = right.next ();

        while (i < j) {
            if ( i + j == k ) return true;
            if ( i + j < k ) i = left.next ();
            else j = right.next ();
        }
        return false;
    }
}
