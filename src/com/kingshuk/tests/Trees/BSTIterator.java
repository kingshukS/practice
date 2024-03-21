package com.kingshuk.tests.Trees;

import java.util.Stack;

class BSTIterator {
    private final Stack<TreeNode> s = new Stack<> ();

    public BSTIterator ( TreeNode root ) {
        push ( root );
    }

    public int next () {
        TreeNode root = s.pop ();
        push ( root.right );
        return root.data;
    }

    public boolean hasNext () {
        return ! s.isEmpty ();
    }

    private void push ( TreeNode root ) {
        while (root != null) {
            s.push ( root );
            root = root.left;
        }
    }
}