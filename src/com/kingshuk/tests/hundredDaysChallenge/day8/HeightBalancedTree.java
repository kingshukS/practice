package com.kingshuk.tests.hundredDaysChallenge.day8;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class HeightBalancedTree {
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);

        if(Math.abs(l-r) > 1)
            res = false;
        return 1 + Math.max(l,r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        HeightBalancedTree heightBalancedTree = new HeightBalancedTree();
        System.out.println("is balanced: "+heightBalancedTree.isBalanced(root));
    }
}
