package com.kingshuk.tests.hundredDaysChallenge.day7;

import java.util.StringJoiner;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                .add("key=" + key)
                .toString();
    }
}
