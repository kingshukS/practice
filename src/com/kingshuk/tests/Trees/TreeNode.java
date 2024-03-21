package com.kingshuk.tests.Trees;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode ( int data ) {
        this.data = data;
    }

    public int getData () {
        return data;
    }

    public void setData ( int data ) {
        this.data = data;
    }

    public TreeNode getLeft () {
        return left;
    }

    public void setLeft ( TreeNode left ) {
        this.left = left;
    }

    public TreeNode getRight () {
        return right;
    }

    public void setRight ( TreeNode right ) {
        this.right = right;
    }


    @Override
    public String toString () {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
