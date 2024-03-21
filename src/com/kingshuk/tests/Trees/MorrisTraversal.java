package com.kingshuk.tests.Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    public List<Integer> morrisInOrderTraversal ( TreeNode root ) {
        List<Integer> nodes = new ArrayList<> ();
        if ( root == null )
            return nodes;
        TreeNode cur = root;
        while (cur != null) {
            if ( cur.left == null ) {
                nodes.add ( cur.data );
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if ( prev.right == null ) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    nodes.add ( cur.data );
                    cur = cur.right;
                }
            }
        }
        return nodes;
    }

    public List<Integer> morrisPreOrderTraversal ( TreeNode root ) {
        List<Integer> nodes = new ArrayList<> ();
        if ( root == null )
            return nodes;
        TreeNode cur = root;
        while (cur != null) {
            if ( cur.left == null ) {
                nodes.add ( cur.data );
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if ( prev.right == null ) {
                    prev.right = cur;
                    // one line change from InOrder
                    nodes.add ( cur.data );
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return nodes;
    }
}
