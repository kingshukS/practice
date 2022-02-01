package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

public class SumOftree {

    static int SumTree(TreeNode root)
    {
        if(root==null)
            return 0;
            return (root.data+SumTree(root.left)+SumTree(root.right));
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right= new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        int sum = SumTree(root);
        System.out.print(sum);
    }
}
