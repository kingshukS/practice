package com.kingshuk.tests.Trees;

public class BSTInorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        TreeNode successor = null;

        while(root != null)
        {
            if(root.data <= p.data)
            {
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
