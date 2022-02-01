package com.kingshuk.tests.Trees;


import com.kingshuk.tests.InorderTraversal.TreeNode;

public class MaximumSumPath {
    TreeNode root;
    static private int res;

    int findMaxUtil(TreeNode node,int res1)
    {
        if(node == null)
        {
            return 0;
        }

        int l = findMaxUtil(node.left,res);
        int r = findMaxUtil(node.right,res);

        int s1 = Math.max(node.data+Math.max(l,r),node.data);

        int s2 = Math.max(s1,(l+r+node.data));

        res1 = Math.max(res,s2);
        res = res1;
        return s1;
    }
     int FindmaxSum()
    {
        return FindmaxSum(root);
    }

    int FindmaxSum(TreeNode node)
    {
        res = Integer.MIN_VALUE;
        findMaxUtil(node,res);
        return res;
    }
    public static void main(String args[])
    {
        MaximumSumPath m = new MaximumSumPath();
        m.root = new TreeNode(10);
        m.root.left= new TreeNode(2);
        m.root.right = new TreeNode(10);
        m.root.left.left = new TreeNode(20);
        m.root.left.right = new TreeNode(1);
      //  m.root.right.left = new Node(6);
        m.root.right.right = new TreeNode(-25);
        m.root.right.right.right = new TreeNode(4);
        m.root.right.right.left = new TreeNode(3);

        System.out.println("Max sum possible is : "+m.FindmaxSum());

    }
}

//Approach : For each node there can be four ways that the max path goes through the node:
//1. Node only
//2. Max path through Left Child + Node
//3. Max path through Right Child + Node
//4. Max path through Left Child + Node + Max path through Right Child
//
//The idea is to keep trace of four paths and pick up the max one in the end.
// An important thing to note is, root of every subtree need to return maximum
// path sum such that at most one child of root is involved.
// This is needed for parent function call. In below code,
// this sum is stored in ‘max_single’ and returned by the recursive function.