package com.kingshuk.tests.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    TreeNode root;
    void levelOrderTrav()
    {
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while(!tree.isEmpty())
        {
            TreeNode temp = tree.poll();
            System.out.println(temp.data+" ");
            if(temp.left!=null)
            {
                tree.add(temp.left);
            }
            if (temp.right!=null)
            {
                tree.add(temp.right);
            }
        }

    }
    public static void main(String[] args)
    {
        LevelOrder tree_level = new LevelOrder();
        tree_level.root = new TreeNode(1);
        tree_level.root.left= new TreeNode(2);
        tree_level.root.right = new TreeNode(3);
        tree_level.root.left.left = new TreeNode(4);
        tree_level.root.left.right = new TreeNode(5);
        tree_level.levelOrderTrav();
    }
}


