package com.kingshuk.tests.hundredDaysChallenge.day9;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return constructBinaryTreeFromSortedArray(nums, 0, nums.length - 1);
    }

    public TreeNode constructBinaryTreeFromSortedArray(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBinaryTreeFromSortedArray(nums, left, mid - 1);
        node.right = constructBinaryTreeFromSortedArray(nums, mid + 1, right);
        return node;
    }
}