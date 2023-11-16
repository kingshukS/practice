package com.kingshuk.tests.Trees;

public class AlternateLevel {

    static void alternateNodes(NodeN root)
    {
        if(root==null)
            return;
        doReverse(root.left,root.right,0);
    }
    static void doReverse(NodeN rootLeft,NodeN rootRight,int level)
    {
        if(rootLeft == null || rootRight == null)
        return;

        if(level%2==0)
        {
            char key = rootLeft.data;
            rootLeft.data=rootRight.data;
            rootRight.data = key;
        }

        doReverse(rootLeft.left,rootRight.right,level+1);
        doReverse(rootLeft.right,rootRight.left,level+1);

    }
    static void printInorder( NodeN root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print( root.data + " ");
        printInorder(root.right);
    }
    public static void main(String[] args)
    {
        NodeN root = new NodeN('a');
        root.left = new NodeN('b');
        root.right = new NodeN('c');
        root.left.left = new NodeN('d');
        root.left.right = new NodeN('e');
        root.right.left = new NodeN('f');
        root.right.right = new NodeN('g');
        root.left.left.left = new NodeN('h');
        root.left.left.right = new NodeN('i');
        root.left.right.left = new NodeN('j');
        root.left.right.right = new NodeN('k');
        root.right.left.left = new NodeN('l');
        root.right.left.right = new NodeN('m');
        root.right.right.left = new NodeN('n');
        root.right.right.right = new NodeN('o');

        printInorder(root);
        System.out.println();
        alternateNodes(root);
        printInorder(root);
    }
}
class NodeN
{
    char data; //data of the node

    NodeN left, right; //left and right references

    // Constructor of tree node
    public NodeN(char key)
    {
        data = key;
        left = right = null;
    }
}

