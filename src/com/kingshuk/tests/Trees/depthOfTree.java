package com.kingshuk.tests.Trees;

public class depthOfTree {

    static int Treedepth ( TreeNode root ) {
        if ( root == null ) {
            return 0;
        } else {
            int lDepth = Treedepth ( root.left );
            int rDepth = Treedepth ( root.right );

            if ( lDepth > rDepth ) {
                return lDepth + 1;
            } else
                return rDepth + 1;
        }
    }

    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 1 );
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 3 );
        root.left.left = new TreeNode ( 7 );
        root.left.right = new TreeNode ( 6 );
        root.right.left = new TreeNode ( 5 );
        root.right.right = new TreeNode ( 4 );
        System.out.println ( "Depth of tree is " + Treedepth ( root ) );
    }
}
