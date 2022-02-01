package com.kingshuk.tests.Important;
import java.util.ArrayList;
import java.util.Stack;

public class CheckForBST {

    static boolean isBST(Node1 root)
    {
       Stack<Node1> st = new Stack<>();
        Node1 curr = root;
        ArrayList<Integer> al = new ArrayList<>();
       while(curr!=null || st.size()>0)
       {

           while (curr !=  null)
           {
               st.push(curr);
               curr = curr.left;
           }
           curr = st.pop();
           al.add(curr.data);
           System.out.print(curr.data + " ");

           curr = curr.right;
       }

        for(int i = 0;i<al.size();i++)
        {
          if(al.get(i)>al.get(i+1))
            {
                return false;
            }
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        Node1 root = new Node1(4);
        root.left= new Node1(2);
        root.right = new Node1(5);
        root.left.left = new Node1(1);
        root.left.right = new Node1(3);
        if(isBST(root))
        {
            System.out.println("It is a BST");
        }
        else
            System.out.println("Not a BST");
    }
}
 class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data)
    {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node1 getLeft() {
        return left;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public Node1 getRight() {
        return right;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }
}


