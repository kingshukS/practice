package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

public class SubbtreeSum {

    static int isSubtreeSum(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        if(node.left == null && node.right == null)
        {
            return node.data;
        }

        if(node.data == isSubtreeSum(node.left) + isSubtreeSum(node.right))
        {
            return 2 * node.data;
        }

        return Integer.MIN_VALUE;
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(26);
        root.left= new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        if(isSubtreeSum(root) == Integer.MIN_VALUE)
            System.out.println("Subtree is not possible");
        else
            System.out.println("Subtree is possible");
    }
}
