package com.kingshuk.tests.Trees;

public class BoundaryTraversal {

    static void boundaryTraversal(NodeT root) {
        printRoot(root);
        if (root.left != null) {
            leftView(root.left);
        }
        printLeafNodes(root);
        if (root.right != null) {
            rightView(root.right);
        }
    }

    static void printLeafNodes(NodeT root) {
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            printLeafNodes(root.left);
        }
        if (root.right != null) {
            printLeafNodes(root.right);
        }
    }

    static void leftView(NodeT root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.left == null) {
            leftView(root.right);
        } else
            leftView(root.left);
    }

    static void rightView(NodeT root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.right == null)
            rightView(root.left);
        else
            rightView(root.right);
        System.out.println(root.data + " ");
    }

    static void printRoot(NodeT root) {
        if (root != null)
            System.out.print(root.data + " ");
    }

    public static void main(String args[]) {
        NodeT root = new NodeT(100);
        root.left = new NodeT(50);
        root.right = new NodeT(150);
        root.left.left = new NodeT(25);
        root.left.right = new NodeT(75);
        root.right.left = new NodeT(140);
        root.right.right = new NodeT(142);
        root.left.right.left = new NodeT(30);
        root.left.right.right = new NodeT(70);
        root.left.left.left = new NodeT(10);
        root.left.left.right = new NodeT(130);
        root.right.right.right = new NodeT(90);
        root.right.right.left = new NodeT(110);
        boundaryTraversal(root);
    }
}
