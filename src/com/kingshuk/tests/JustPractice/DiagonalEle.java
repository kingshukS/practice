package com.kingshuk.tests.JustPractice;

import com.kingshuk.tests.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalEle {
    static void diagonalTraversal(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
       while(!q.isEmpty())
        {
            TreeNode temp = q.peek();
            q.remove();
            if(temp == null)
            {
                if(q.size()==0)
                    return;
                System.out.println();
                q.add(null);
            }
            else
                while(temp!=null)
                {
                    System.out.print(temp.data+" ");
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    temp = temp.right;
                }

        }
    }
    public static void main(String[] args)
    {
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
