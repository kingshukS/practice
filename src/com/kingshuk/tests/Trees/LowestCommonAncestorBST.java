package com.kingshuk.tests.Trees;

class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor ( TreeNode root, TreeNode p, TreeNode q ) {
        if ( root == null ) return null;
        if ( root.data > p.data && root.data > q.data )
            return lowestCommonAncestor ( root.left, p, q );
        else if ( root.data < p.data && root.data < q.data )
            return lowestCommonAncestor ( root.right, p, q );
        return root;
    }
}