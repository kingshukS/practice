package com.kingshuk.tests.Trees;

class BSTDeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.data == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (dummy != null) {
            if (dummy.data > key) {
                if (dummy.left != null && dummy.left.data == key) {
                    dummy.left = helper(dummy.left);
                    break;
                } else {
                    dummy = dummy.left;
                }
            } else {
                if (dummy.right != null && dummy.right.data == key) {
                    dummy.right = helper(dummy.right);
                    break;
                } else {
                    dummy = dummy.right;
                }
            }
        }
        return root;
    }

    private TreeNode helper(TreeNode node) {
        if (node.left == null)
            return node.right;
        else if (node.right == null)
            return node.left;
        else {
            TreeNode right = node.right;
            TreeNode leftsRight = findRight(node.left);
            leftsRight.right = right;
            return node.left;
        }
    }

    private TreeNode findRight(TreeNode root) {
        TreeNode node = root;
        while (node.right != null)
            node = node.right;
        return node;
    }
}