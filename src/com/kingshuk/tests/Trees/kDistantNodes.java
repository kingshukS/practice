package com.kingshuk.tests.Trees;


import com.kingshuk.tests.InorderTraversal.TreeNode;

public class kDistantNodes {


    static void printknodeDistanceDown(TreeNode root, int k)
    {
        if(root==null || k<0)
        {
            return;
        }

        if(k==0)
        {
            System.out.println(root.data);
            System.out.println(" ");
            return;
        }

        printknodeDistanceDown(root.left,k-1);
        printknodeDistanceDown(root.right,k-1);

    }
    static int printkdistanceNode(TreeNode root,TreeNode target,int k)
    {
        if(root==null)
        {
            return -1 ;
        }

        if(root == target)
        {
            printknodeDistanceDown(root,k);
            return 0;
        }
        int dl = printkdistanceNode(root.left,target,k);

        if(dl!=-1)
        {
            if(dl+1==k)
            {
                System.out.println(root.data);
                System.out.println(" ");
            }
            else
            {
                printknodeDistanceDown(root.right, k - dl - 2);
            }
            return 1 + dl;
        }
        int dr = printkdistanceNode(root.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
            {
                System.out.print(root.data);
                System.out.println("");
            }
            else
                printknodeDistanceDown(root.left, k - dr - 2);
            return 1 + dr;
        }
        return -1;
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left;
        printkdistanceNode(root, target, 2);
    }
}
