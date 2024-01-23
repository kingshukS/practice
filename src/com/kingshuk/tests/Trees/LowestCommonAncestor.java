package com.kingshuk.tests.Trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5) = "
                + findLCA(root, 4, 5));
        System.out.println("LCA(4, 6) = "
                + findLCA(root, 4, 6));
        System.out.println("LCA(3, 4) = "
                + findLCA(root, 3, 4));
        System.out.println("LCA(2, 4) = "
                + findLCA(root, 2, 4));
    }

    private static String findLCA(TreeNode root, int n1, int n2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        if (!findPath(root, n1, list1) || !findPath(root, n2, list2))
            return "NOT_POSSIBLE";
        int min = Math.min(list1.size(), list2.size());
        for (int i = 0; i < min; i++) {
            if (!list1.get(i).equals(list2.get(i)))
                return list1.get(i - 1).toString();
        }
        return list1.get(min-1).toString();
    }

    private static int findLCA2(TreeNode root, int n1, int n2) {
        if(root == null)
            return -1;
        if(root.data == n1 || root.data == n2)
            return root.data;
        int left = findLCA2(root.left, n1, n2);
        int right = findLCA2(root.right, n1, n2);

        if(left != -1 && right != -1)
            return root.data;
        return left != -1 ? left : right;
    }

    private static boolean findPath(TreeNode root, int n, List<Integer> list) {
        if (root == null)
            return false;
        list.add(root.data);
        if (root.data == n)
            return true;
        if (findPath(root.left, n, list) || findPath(root.right, n, list))
            return true;
        list.remove(list.size() - 1);
        return false;
    }
}
