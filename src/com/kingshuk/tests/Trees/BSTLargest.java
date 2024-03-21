package com.kingshuk.tests.Trees;

public class BSTLargest {

    public static int largestBST ( TreeNode root ) {
        return findLargestBST ( root ).size;
    }

    private static NodeInfo findLargestBST ( TreeNode root ) {
        if ( root == null ) {
            return new NodeInfo ( 0, Integer.MAX_VALUE, Integer.MIN_VALUE );
        }

        NodeInfo left = findLargestBST ( root.left );
        NodeInfo right = findLargestBST ( root.right );

        // it is BSTree. size is determined through left and right's size + 1,
        // min is the minimum value of left and root
        // max is the maximum value of right and root
        if ( left.max < root.data && right.min > root.data ) {
            return new NodeInfo ( left.size + right.size + 1, Math.min ( left.min, root.data ), Math.max ( root.data, right.max ) );
        } else {
            // not a BSTree, min is set to INT_MIN and max is set to INT_MAX,
            // which resist its parent to become a valid BSTree
            return new NodeInfo ( Math.max ( left.size, right.size ), Integer.MIN_VALUE, Integer.MAX_VALUE );
        }
    }

    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 5 );
        root.left = new TreeNode ( 2 );
        root.right = new TreeNode ( 4 );
        root.left.left = new TreeNode ( 1 );
        root.left.right = new TreeNode ( 3 );
        System.out.println ( largestBST ( root ) );
    }

    static class NodeInfo {
        int size;
        int min;
        int max;

        public NodeInfo ( int size, int min, int max ) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}