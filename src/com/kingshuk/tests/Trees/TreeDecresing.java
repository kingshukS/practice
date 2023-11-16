package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.Stack;

public class TreeDecresing {

    static void decreasingInOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> st = new Stack<>();
        while(current!=null || st.size()>0)
        {

            while(current!=null)
            {
                st.push(current);
                current = current.right;
            }
            current = st.pop();
            System.out.print(current.data+" ");
            current = current.left;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(19);
        decreasingInOrder(root);
    }
}
