package com.kingshuk.tests.Trees;

import com.kingshuk.tests.InorderTraversal.TreeNode;

public class MirrorImage {

    static boolean isMirror(TreeNode a , TreeNode b)
    {
        if(a == null && b==null)
            return true;

        if(a==null || b==null)
            return false;

        return (a.data == b.data )
                &&isMirror(a.left,b.right)
                &&isMirror(a.right,b.left);
    }
    public static void main(String[] args)
    {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(5);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);

        if(isMirror(a, b))
        {
            System.out.print("Yes");
        }
        else
            System.out.print("No");
    }
}
