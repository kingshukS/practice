package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLevelWise {

    private static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            System.out.println("\nLevel:" + level);
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.data + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }
        public static void main (String args[])
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            levelOrderTraversal(root);
        }
    }


