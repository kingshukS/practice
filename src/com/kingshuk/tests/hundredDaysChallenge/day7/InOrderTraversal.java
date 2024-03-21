package com.kingshuk.tests.hundredDaysChallenge.day7;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 10 );
        root.left = new TreeNode ( 20 );
        root.right = new TreeNode ( 30 );
        root.left.left = new TreeNode ( 40 );
        root.left.right = new TreeNode ( 50 );
        root.right.right = new TreeNode ( 60 );
        root.left.right.left = new TreeNode ( 70 );
        root.left.right.right = new TreeNode ( 80 );
        List<Integer> inOrderTraversalList = new ArrayList<> ();
        inOrder ( root, inOrderTraversalList );
        inOrderTraversalList.stream ().forEach ( System.out::println );
    }

    private static void inOrder ( TreeNode root, List<Integer> list ) {
        if ( root == null )
            return;
        inOrder ( root.left, list );
        list.add ( root.key );
        inOrder ( root.right, list );
    }
}
