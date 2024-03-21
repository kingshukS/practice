package com.kingshuk.tests.Trees;

class BSTInsertANode {
    public TreeNode insertIntoBST ( TreeNode root, int val ) {
        TreeNode cur = root;
        if ( root == null )
            return new TreeNode ( val );
        while (true) {
            if ( root.data <= val ) {
                if ( root.right != null ) root = root.right;
                else {
                    root.right = new TreeNode ( val );
                    break;
                }
            } else {
                if ( root.left != null ) root = root.left;
                else {
                    root.left = new TreeNode ( val );
                    break;
                }
            }
        }
        return cur;
    }
}