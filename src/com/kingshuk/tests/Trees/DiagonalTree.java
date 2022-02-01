package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.*;

public class DiagonalTree {

    static void diagonalTraversal(TreeNode root)
    {
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        s.add(null);

        while (!s.isEmpty())
        {
            TreeNode temp =  s.peek();
            s.remove();
            if(temp == null){
                if(s.size()==0)
                    return;
                System.out.println();
                s.add(null);
            }
            else {
                while(temp!=null){
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                s.add(temp.left);
                temp = temp.right;
            }
            }
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right= new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        diagonalTraversal(root);
    }
}
