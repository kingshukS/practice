package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTree2 {

    static void zigZagTraversal(TreeNode root) {
        Deque<TreeNode> dequeue = new LinkedList<>();
        boolean flag  = true;
        dequeue.add(root);
        while(!dequeue.isEmpty()){
            int size = dequeue.size();
            for(int i = 0; i<size; i++){
                if(flag)
                {
                    TreeNode current = dequeue.pollFirst();
                    System.out.print(current.data+" ");
                    if(current.left != null)
                        dequeue.offerLast(current.left);
                    if(current.right != null)
                        dequeue.offerLast(current.right);
                }else{
                    TreeNode current = dequeue.pollLast();
                    System.out.print(current.data+" ");
                    if(current.right != null)
                        dequeue.offerFirst(current.right);
                    if(current.left != null)
                        dequeue.offerFirst(current.left);
                }
            }
            flag = !flag;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        zigZagTraversal(root);
    }
}
