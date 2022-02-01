package com.kingshuk.tests.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CheckIfBST {

    static boolean checkForBST(NodeT root)
    {
        if(root == null)
        {
            return false;
        }

        Stack<NodeT> st = new Stack<>();
        NodeT curr = root;
        ArrayList<Integer> al = new ArrayList<>();
        while(curr!=null || st.size()>0)
        {
            while(curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            al.add(curr.data);
            System.out.print(curr.data+" ");
            curr = curr.right;
        }

        for(int i= 1;i<=al.size()-1;i++)
        {
            if(al.get(i-1)>al.get(i))
                return false;
        }
       return true;
    }
    public static void main(String args[])
    {
        NodeT root = new NodeT(15);
        root.left = new NodeT(13);
        root.right = new NodeT(18);
        root.left.left = new NodeT(12);
        root.left.right = new NodeT(14);
        root.right.left = new NodeT(16);
        root.right.right = new NodeT(19);

        System.out.println("the given tree is BST : "+checkForBST(root));
    }
}
