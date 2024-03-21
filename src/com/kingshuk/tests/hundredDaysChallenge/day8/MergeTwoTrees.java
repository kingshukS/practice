package com.kingshuk.tests.hundredDaysChallenge.day8;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

public class MergeTwoTrees {
    public TreeNode mergeTrees ( TreeNode root1, TreeNode root2 ) {
        TreeNode res = merge ( root1, root2 );
        return res;
    }

    public TreeNode merge ( TreeNode root1, TreeNode root2 ) {
        if ( root1 == null && root2 == null )
            return null;
        if ( root1 == null )
            return root2;
        if ( root2 == null )
            return root1;

        root1.key = root1.key + root2.key;
        root1.left = merge ( root1.left, root2.left );
        root1.right = merge ( root1.right, root2.right );
        return root1;
    }
}
