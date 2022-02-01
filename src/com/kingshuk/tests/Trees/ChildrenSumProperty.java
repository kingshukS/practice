package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

public class ChildrenSumProperty {
    static boolean isSumProp(TreeNode node)
    {
        int left_data = 0;
        int right_data = 0;
        if((node == null) || ((node.left == null) && (node.right == null)))
            return true;
        else {
            if(node.left!=null)
            left_data = node.left.data;
            if(node.right!=null)
            right_data = node.right.data;

            if(node.data == left_data+right_data && isSumProp(node.left) && isSumProp(node.right))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(10);
        root.left= new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        System.out.println("whether this tree satisfies sum property "+isSumProp(root));

    }
}
