package com.kingshuk.tests.hundredDaysChallenge.day7;

public class InvertTree {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 10 );
        root.left = new TreeNode ( 20 );
        root.right = new TreeNode ( 30 );
        root.left.left = new TreeNode ( 40 );
        root.left.right = new TreeNode ( 50 );
        root.right.right = new TreeNode ( 60 );
        root.left.right.left = new TreeNode ( 70 );
        root.left.right.right = new TreeNode ( 80 );
        root = invertTree ( root );
    }

    public static TreeNode invertTree ( TreeNode root ) {
        if ( root != null ) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invertTree ( root.left );
            invertTree ( root.right );

        }
        return root;
    }
}
