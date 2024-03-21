package com.kingshuk.tests.Trees;

import java.util.Stack;

public class PreOrderIterative {
    void iterativePreorder ( TreeNode root ) {
        if ( root == null ) {
            return;
        }
        // Create an empty stack and push root to it
        Stack<TreeNode> treeNodes = new Stack<> ();
        treeNodes.push ( root );
 
        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (! treeNodes.empty ()) {

            // Pop the top item from stack and print it
            TreeNode node = treeNodes.peek ();
            System.out.print ( node.data + " " );
            treeNodes.pop ();

            // Push right and left children of the popped root to stack
            if ( node.right != null ) {
                treeNodes.push ( node.right );
            }
            if ( node.left != null ) {
                treeNodes.push ( node.left );
            }
        }
    }
}