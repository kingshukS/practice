package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

public class MirrorNode {
    static int mirrorNode(TreeNode root , int target)
    {
        if(root == null)
        {
            return  0;
        }
        if(root.data == target)
        {
            return root.data;
        }
        return mirrorNodeRecursion(root.left,root.right,target);
    }

    static int mirrorNodeRecursion(TreeNode left,TreeNode right, int target)
    {
        if(left ==  null || right == null)
        {
            return 0;
        }

        if(left.data == target)
            return right.data;

        if(right.data == target)
            return left.data;

        int mirror_val = mirrorNodeRecursion(left.left,right.right,target);
        if(mirror_val!=0)
        {
            return mirror_val;
        }
        return mirrorNodeRecursion(left.right,right.left,target);
    }
    public static void main(String[] args)
    {
        TreeNode root  = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        int target = root.left.left.data;
        System.out.println("The mirror node for this target is : "+mirrorNode(root,target));
    }
}
