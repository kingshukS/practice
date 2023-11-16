package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {
        public static void main (String[] args)
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.right = new TreeNode(6);
            root.left.right.right.left = new TreeNode(7);
            int size = sizeOfBinaryTree(root);
            System.out.println("Size:"+size);
        }

    private static int sizeOfBinaryTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size = 0;
            while (!queue.isEmpty()){
                TreeNode current = queue.poll();
                size++;
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
            }
            return size;
    }
}


