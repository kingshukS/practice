package com.kingshuk.tests.hundredDaysChallenge.day8;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        boolean result = false;
        if(root.key == subRoot.key)
            result = compare(root, subRoot);
        if(result)
            return true;
            
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean compare(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.key == root2.key)
            return compare(root1.left, root2.left) && compare(root1.right, root2.right);
        return false;
    }
}