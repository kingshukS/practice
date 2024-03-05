package com.kingshuk.tests.Trees;

class BSTCorrectSwappedNodes {
    private TreeNode prev, first, last, middle;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last!= null)
        {
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }else if(first != null && middle!= null)
        {
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }

    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        if(root.data < prev.data)
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}