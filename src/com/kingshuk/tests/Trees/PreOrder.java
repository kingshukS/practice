package com.kingshuk.tests.Trees;

public class PreOrder {

}/*{
private Node rootNode;
public void addNode(Node rootNode ,int data){
    if(rootNode == null)
    {
        Node temp = new Node(data);
        this.rootNode = temp;
    }
    else{
        addNodeInProperPlace(rootNode,data);
    }
}
public void postOrder(Node rootNode)
{
    if(rootNode==null) {
        return;
    }
        postOrder(rootNode.left());
        postOrder(rootNode.getRight());
        System.out.println(rootNode.getData());

}
public void inOrder(Node rootNode)
{
    if(rootNode==null)
    {
        return;
    }
    inOrder(rootNode.getLeft());
    System.out.println(rootNode.getData());
    inOrder(rootNode.getRight());
}
public void preOrder(Node rootNode)
{
    if(rootNode == null)
    {
        return;
    }
    System.out.println(rootNode.getData()+ " ");
    preOrder(rootNode.getLeft());
    preOrder(rootNode.getRight());
}

public void addNodeInProperPlace(Node rootNode,int data)
{
    if(data>rootNode.getData())   //if data node is less than its root.
    {
            if(rootNode.getRight()!=null)
            {
                addNode(rootNode.getRight(),data);
            }
            else {
                Node temp = new Node(data);
                rootNode.setRight(temp);
            }
    }
    else
    {
            if(data<rootNode.getData())
            {
                if(rootNode.getLeft()!=null)
                {
                    addNode(rootNode.getLeft(),data);
                }else{
                    Node temp = new Node(data);
                    rootNode.setLeft(temp);
                }
            }
    }
}
public PreOrder()
{
    addNode(rootNode,45);
    addNode(rootNode,25);
    addNode(rootNode, 75);
    addNode(rootNode, 15);
    addNode(rootNode, 35);
    System.out.println("Pre order traversal is ");
    preOrder(rootNode);
    System.out.println("In order traversal is ");
    inOrder(rootNode);
    System.out.println("Post order traversal is ");
    postOrder(rootNode);
}
public static void main(String args[])
{
   new PreOrder();
}
}*/
/*
class Node
{
    Node left,right;
    int data;
    public Node(int data)
    {
        this.data = data;
        left = null;
        right = null;

    }
}
*/
