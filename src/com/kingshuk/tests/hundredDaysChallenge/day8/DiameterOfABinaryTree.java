package com.kingshuk.tests.hundredDaysChallenge.day8;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class DiameterOfABinaryTree {
     private int res = 0;
     public int diameter(TreeNode root) {
         if(root == null)
             return 0;
         int l = diameter(root.left);
         int r = diameter(root.right);

         int s1 = 1 + Math.max(l,r);
         int s2 = l+r+1;
         res = Math.max(res, s2);
         return s1;
     }
}
