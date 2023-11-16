package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.Stack;

public class InOrderWithoutRecursion {

    TreeNode root;
    void InOrder()
    {
        if(root == null)
        {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode temp = root;
        while (!s.isEmpty() || s.size()>0)
        {

           while(temp!=null)
           {
               s.push(temp);
               temp = temp.left;
           }
            temp = s.pop();
            System.out.print(temp.data+" ");
            temp = temp.right;
        }


    }
    public static void main(String[] args)
    {
        InOrderWithoutRecursion inOrderWithoutRecursion = new InOrderWithoutRecursion();
        inOrderWithoutRecursion.root = new TreeNode(1);
        inOrderWithoutRecursion.root.left = new TreeNode(2);
        inOrderWithoutRecursion.root.right = new TreeNode(3);
        inOrderWithoutRecursion.root.left.left = new TreeNode(4);
        inOrderWithoutRecursion.root.left.right = new TreeNode(5);
        inOrderWithoutRecursion.InOrder();
    }
}


