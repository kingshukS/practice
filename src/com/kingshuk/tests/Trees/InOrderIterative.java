package com.kingshuk.tests.Trees;

import java.util.Stack;

public class InOrderIterative {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 1 );
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 3 );
        root.left.left = new TreeNode ( 4 );
        root.left.right = new TreeNode ( 5 );
        new InOrderIterative ().inOrderIterative ( root );
    }

    void inOrderIterative ( TreeNode root ) {
        if ( root == null ) {
            return;
        }
        Stack<TreeNode> s = new Stack<> ();
        TreeNode temp = root;
        while (temp != null || ! s.isEmpty ()) {
            while (temp != null) {
                s.push ( temp );
                temp = temp.left;
            }
            temp = s.pop ();
            System.out.print ( temp.data + " " );
            temp = temp.right;
        }


    }
}


