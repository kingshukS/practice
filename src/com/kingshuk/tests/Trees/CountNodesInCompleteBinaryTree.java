package com.kingshuk.tests.Trees;

public class CountNodesInCompleteBinaryTree {
    public int countNodes ( TreeNode root ) {
        if ( root == null ) return 0;

        int lh = getLeftHeight ( root.left );
        int rh = getRightHeight ( root.right );

        if ( lh == rh ) return ( ( 2 << lh ) - 1 );

        else return 1 + countNodes ( root.left ) + countNodes ( root.right );
    }

    int getLeftHeight ( TreeNode root ) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    int getRightHeight ( TreeNode root ) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
