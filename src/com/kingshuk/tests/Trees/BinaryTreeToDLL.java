package com.kingshuk.tests.Trees;

public class BinaryTreeToDLL {

    private TreeNode prev = null;

    public TreeNode convert(TreeNode root) {
        if (root == null)
            return null;
        TreeNode head = null;
        convert(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
        return head;
    }
}
