package com.kingshuk.tests.Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(root));
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));
        int ans = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int first = 0;
            int last = 0;
            int min = queue.peek().index;
            for(int i = 0; i<size; i++)
            {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index-min;

                if(i == 0) first = index;
                if(i == size - 1) last = index;

                if(node.left != null) queue.add(new Pair(node.left, 2*index+1));
                if(node.right != null) queue.add(new Pair(node.right, 2*index+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
