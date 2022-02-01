package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

import java.util.Stack;

public class ZigZagTree {

    static void zigZagTraversal(TreeNode root){
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToright = true;
        currentLevel.push(root);
        while(!currentLevel.isEmpty())
        {
            TreeNode curr = currentLevel.pop();
                System.out.print(curr.data+" ");
                if (leftToright) {
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                }
                if (!leftToright) {
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }

            }

            if(currentLevel.isEmpty())
            {
                leftToright = !leftToright;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
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
        zigZagTraversal(root);
    }
}
