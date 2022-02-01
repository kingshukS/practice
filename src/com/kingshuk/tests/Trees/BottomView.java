package com.kingshuk.tests.Trees;

import java.util.*;

public class BottomView {
    NodeT root; //root node of tree
    public BottomView(NodeT node) {
       root = node;
    }
    public void bottomView()
    {
        if(root == null)
        {
            return;
        }
        int hd = 0;
        Queue<NodeT> q = new LinkedList<>();
        q.add(root);
        root.hd = hd;

        Map<Integer,Integer> hm = new HashMap<>();

        while (!q.isEmpty())
        {
            NodeT temp = q.remove();
            hd = temp.hd;
            if(!hm.containsKey(hd)) {
                hm.put(hd, temp.data);
            }
            if(temp.left!=null)
            {
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }

        Set<Map.Entry<Integer,Integer>> entry = hm.entrySet();
       for(Map.Entry<Integer,Integer> itr : entry)
       {
            System.out.print(itr.getValue()+" ");
       }
    }
    public static void main(String[] args)
    {
        NodeT root = new NodeT(20);
        root.left = new NodeT(8);
        root.right = new NodeT(22);
        root.left.left = new NodeT(5);
        root.left.right = new NodeT(3);
        root.right.left = new NodeT(4);
        root.right.right = new NodeT(25);
        root.left.right.left = new NodeT(10);
        root.left.right.right = new NodeT(14);
        BottomView tree = new BottomView(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }
}
class NodeT
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    NodeT left, right; //left and right references

    // Constructor of tree node
    public NodeT(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
