package com.kingshuk.tests.InorderTraversal;

import com.kingshuk.tests.Trees.TreeNode;

public class InOrderTraversal {
    static TreeNode rootNode;
    public InOrderTraversal()
    {
        addNode(rootNode,10);
        addNode(rootNode,20);
        addNode(rootNode,34);
        addNode(rootNode,26);
        addNode(rootNode,70);
        addNode(rootNode,25);
        addNode(rootNode,15);
        addNode(rootNode,100);

        System.out.println("After inorder traversal.");
        InOrederTest(rootNode);

    }

    private void InOrederTest(TreeNode rootNode) {
        if(rootNode==null)
        {
            return;
        }
        InOrederTest(rootNode.getLeft());
        System.out.println(rootNode.data);
        InOrederTest(rootNode.getRight());
    }

    public static void main(String[] args)
    {
        new InOrderTraversal();
    }
    public void addNode(TreeNode rootNode, int data)
    {
        if(rootNode==null)
        {
            TreeNode temp = new TreeNode(data);
            InOrderTraversal.rootNode = temp;
        }
        else
        {
            addNodeInProperPlace(rootNode,data);
        }
    }
    public void addNodeInProperPlace(TreeNode rootNode, int data)
    {
            if(data > rootNode.data)
            {
                if(rootNode.getRight()!=null)
                {
                    addNode(rootNode.getRight(),data);
                }
                else{
                    TreeNode temp = new TreeNode(data);
                    rootNode.setRight(temp);
                }
            }
            else if(data < rootNode.data)
            {
                if(rootNode.getLeft()!=null)
                {
                    addNode(rootNode.getLeft(),data);
                }
                else
                {
                    TreeNode temp = new TreeNode(data);
                    rootNode.setLeft(temp);
                }
            }
    }
}
