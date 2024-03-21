package com.kingshuk.tests.InorderTraversal;

import com.kingshuk.tests.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeftView {


    static void treeLeftView ( TreeNode root, int level, Map<Integer, Integer> map ) {
        if ( root == null ) {
            return;
        }
        if ( ! map.containsKey ( level ) ) {
            map.put ( level, root.data );
        } //for left view

        //map.put(level, root.data); //for right view
        treeLeftView ( root.right, level + 1, map );
        treeLeftView ( root.left, level + 1, map );


    }

    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 1 );
        LeftView leftView = new LeftView ();
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 3 );
        root.left.left = new TreeNode ( 4 );
        root.left.right = new TreeNode ( 5 );
        root.right.left = new TreeNode ( 6 );
        root.right.right = new TreeNode ( 7 );
        int level = 0;
        Map<Integer, Integer> map = new HashMap<> ();
        treeLeftView ( root, level, map );
        for ( int i = 0; i < map.size (); i++ ) {
            System.out.println ( map.get ( i ) + " " );
        }

    }
}
