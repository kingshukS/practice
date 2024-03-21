package com.kingshuk.tests.Trees;


public class RootToLeafSum {

    static boolean isRootToLeafPath ( TreeNode node, int sum ) {
        if ( node == null ) {
            return sum == 0;
        }
        return isRootToLeafPath ( node.left, sum - node.data ) ||
                isRootToLeafPath ( node.right, sum - node.data );
    }

    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 10 );
        root.left = new TreeNode ( 8 );
        root.right = new TreeNode ( 2 );
        root.left.left = new TreeNode ( 3 );
        root.left.right = new TreeNode ( 5 );
        root.right.left = new TreeNode ( 2 );
        int sum = 21;
        System.out.println ( "Whether sum is possible : " + isRootToLeafPath ( root, sum ) );
    }
}
