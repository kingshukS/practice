package com.kingshuk.tests.Trees;

public class BSTLowestCommonAncestor {
    public TreeNode lowestCommonAncestor ( TreeNode root, TreeNode p, TreeNode q ) {
        if ( root == null ) return null;
        if ( root.data > p.data && root.data > q.data )
            return lowestCommonAncestor ( root.left, p, q );
        else if ( root.data < p.data && root.data < q.data )
            return lowestCommonAncestor ( root.right, p, q );
        return root;
    }
}
