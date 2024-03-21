package com.kingshuk.tests.hundredDaysChallenge.day7;

public class SymmetricTree {
    public boolean isSymmetric ( TreeNode root ) {
        if ( root == null )
            return true;

        return isSymmetric ( root.left, root.right );
    }

    private boolean isSymmetric ( TreeNode left, TreeNode right ) {
        if ( left == null && right == null )
            return true;
        if ( left == null || right == null )
            return false;
        if ( left.key != right.key )
            return false;
        return isSymmetric ( left.left, right.right ) && isSymmetric ( left.right, right.left );
    }
}
