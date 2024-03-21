package com.kingshuk.tests.Trees;

class BSTFromPreorder {

    private int index = 0;

    public TreeNode bstFromPreorder ( int[] preorder ) {
        return bstFromPreorder ( preorder, Integer.MAX_VALUE );
    }

    private TreeNode bstFromPreorder ( int[] preorder, int bound ) {
        if ( index >= preorder.length || preorder[index] > bound ) return null;
        TreeNode root = new TreeNode ( preorder[index++] );
        root.left = bstFromPreorder ( preorder, root.data );
        root.right = bstFromPreorder ( preorder, bound );
        return root;
    }
}