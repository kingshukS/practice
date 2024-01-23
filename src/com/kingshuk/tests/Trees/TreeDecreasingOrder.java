package com.kingshuk.tests.Trees;

public class TreeDecreasingOrder {


    static void decreasingOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        decreasingOrder(root.right);
        System.out.print(root.data+" ");
        decreasingOrder(root.left);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(19);
        decreasingOrder(root);
    }
}
