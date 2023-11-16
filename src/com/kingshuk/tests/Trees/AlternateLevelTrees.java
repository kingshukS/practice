package com.kingshuk.tests.Trees;


import java.util.LinkedList;
import java.util.Queue;

public class AlternateLevelTrees {

    static void alternateLevel(NodeT root)
    {
        Queue<NodeT> s = new LinkedList<>();

        s.add(root);
        System.out.println(root.data+" --> -1");
        while(!s.isEmpty())
        {
            int size = s.size();

            for(int i = 0;i<size;i++)
            {
                NodeT temp = s.poll();
                if(temp.left!=null && temp.right!=null)
                {
                    System.out.println(temp.left.data+" --> "+temp.right.data);
                    s.add(temp.left);
                    s.add(temp.right);
                }
                else if(temp.left!=null)
                    System.out.println(temp.left.data+" --> -1");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        NodeT root = new NodeT(15);
        root.left = new NodeT(13);
        root.right = new NodeT(18);
        root.left.left = new NodeT(12);
        root.left.right = new NodeT(14);
        root.right.left = new NodeT(16);
        root.right.right = new NodeT(19);
        alternateLevel(root);
    }
}
