package com.kingshuk.tests.Trees;

public class BSTCeilAndFloor {
    public static int findCeil(TreeNode node, int x) {

        int ceil = -1;
        while (node != null) {
            if (node.data == x) {
                return node.data;
            }

            if (node.data > x) {
                ceil = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ceil;
    }

    public static int floorInBST(TreeNode root, int X) {
        int floor = -1;

        while (root != null) {
            if (root.data == X)
                return root.data;

            if (root.data > X)
                root = root.left;
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}