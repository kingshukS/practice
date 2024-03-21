package com.kingshuk.tests.Trees;

import java.util.Stack;

class BSTIteratorReverseSupport {
    private final Stack<TreeNode> s = new Stack<> ();
    private final boolean reverse;

    public BSTIteratorReverseSupport ( TreeNode root, boolean reverse ) {
        this.reverse = reverse;
        push ( root );
    }

    public int next () {
        TreeNode root = s.pop ();
        if ( reverse )
            push ( root.left );
        else
            push ( root.right );
        return root.data;
    }

    public boolean hasNext () {
        return ! s.isEmpty ();
    }

    private void push ( TreeNode root ) {
        while (root != null) {
            s.push ( root );
            if ( reverse )
                root = root.right;
            else
                root = root.left;
        }
    }
}