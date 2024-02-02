package com.kingshuk.tests.Trees;

import java.util.Stack;

class PostOrderIterative {
    // An iterative function to do postorder traversal 
    // of a given binary tree
    private void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if (stack.empty()) return;
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root) root = root.right;

            else {

                System.out.print(root.data + " ");
                root = null;
            }
        }
    }
}