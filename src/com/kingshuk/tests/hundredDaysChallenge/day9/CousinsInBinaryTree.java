package com.kingshuk.tests.hundredDaysChallenge.day9;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the
 * nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * <p>
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 */
public class CousinsInBinaryTree {
    public boolean isCousins ( TreeNode root, int x, int y ) {
        if ( root == null )
            return false;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer ( root );
        while (! queue.isEmpty ()) {
            int size = queue.size ();
            boolean isAExist = false;
            boolean isBExist = false;
            for ( int i = 0; i < size; i++ ) {
                TreeNode curr = queue.poll ();
                if ( curr.key == x ) isAExist = true;
                if ( curr.key == y ) isBExist = true;
                if ( curr.left != null && curr.right != null ) {
                    if ( curr.left.key == x && curr.right.key == y )
                        return false;
                    if ( curr.left.key == y && curr.right.key == x )
                        return false;
                }
                if ( curr.left != null )
                    queue.offer ( curr.left );
                if ( curr.right != null )
                    queue.offer ( curr.right );
            }
            if ( isAExist && isBExist )
                return true;
        }
        return false;
    }
}
