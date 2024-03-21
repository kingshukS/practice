package com.kingshuk.tests.Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 1 );
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 3 );
        root.left.left = new TreeNode ( 4 );
        root.left.right = new TreeNode ( 5 );
        root.left.right.left = new TreeNode ( 6 );
        root.left.right.right = new TreeNode ( 7 );

        List<Integer> path = findRootToLeafPath ( root, 7 );
        System.out.println ( path );

    }

    private static List<Integer> findRootToLeafPath ( TreeNode root, int targetLeaf ) {
        List<Integer> res = new ArrayList<> ();
        find ( root, targetLeaf, res );
        return res;
    }

    private static boolean find ( TreeNode root, int targetLeaf, List<Integer> res ) {
        if ( root == null )
            return false;
        res.add ( root.data );
        if ( root.data == targetLeaf ) {
            return true;
        }
        if ( find ( root.left, targetLeaf, res ) || find ( root.right, targetLeaf, res ) )
            return true;
        res.remove ( res.size () - 1 );
        return false;
    }


}
