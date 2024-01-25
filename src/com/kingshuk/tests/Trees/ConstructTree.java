package com.kingshuk.tests.Trees;

public class ConstructTree {
    private int preIndex = 0;

    public TreeNode construct(int[] in, int is, int ie, int[] pre) {
        if (is > ie) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.left = construct(in, is, inIndex - 1, pre);
        root.right = construct(in, inIndex + 1, ie, pre);
        return root;
    }
}
