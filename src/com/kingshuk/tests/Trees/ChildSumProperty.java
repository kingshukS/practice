package com.kingshuk.tests.Trees;

public class ChildSumProperty {
    public static void changeTree(TreeNode root) {
        if(root == null) return;
        int childSum = 0;
        if(root.left != null) childSum+=root.left.data;
        if(root.right != null) childSum+=root.right.data;

        if(childSum >= root.data) root.data = childSum;
        else{
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total+=root.left.data;
        if(root.right != null) total+=root.right.data;

        if(root.left != null || root.right!= null) root.data = total;
    }
}
