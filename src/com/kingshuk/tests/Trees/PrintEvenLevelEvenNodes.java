package com.kingshuk.tests.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintEvenLevelEvenNodes {


    static void printEvenLevelEvenNodes ( Node root ) {
        // Base Case
        if ( root == null )
            return;

        // Create an empty queue for level
        // order traversal
        Queue<Node> q = new LinkedList<Node> ();

        // Enqueue root and initialize level as even
        q.add ( root );
        boolean evenLevel = false;

        while (true) {

            // nodeCount (queue size) indicates
            // number of nodes in the current level
            int nodeCount = q.size ();
            if ( nodeCount == 0 )
                break;

            // Mark 1st node as even positioned
            boolean evenNodePosition = true;

            // Dequeue all the nodes of current level
            // and Enqueue all the nodes of next level
            while (nodeCount > 0) {
                Node node = q.peek ();

                // Print only even positioned
                // nodes of even levels
                if ( evenLevel && evenNodePosition )
                    System.out.print ( node.data + " " );
                q.remove ();
                if ( node.left != null )
                    q.add ( node.left );
                if ( node.right != null )
                    q.add ( node.right );
                nodeCount--;
                evenNodePosition = ! evenNodePosition;
            }

            // Switch the even level flag
            evenLevel = ! evenLevel;
        }
    }

    // Utility method to create a node
    static Node newNode ( int data ) {
        Node node = new Node ();
        node.data = data;
        node.left = node.right = null;
        return ( node );
    }

    public static void main ( String[] args ) {
        Node root = newNode ( 1 );
        root.left = newNode ( 2 );
        root.right = newNode ( 3 );
        root.left.left = newNode ( 4 );
        root.left.right = newNode ( 5 );
        root.right.left = newNode ( 6 );
        root.right.right = newNode ( 7 );
        root.left.right.left = newNode ( 8 );
        root.left.right.right = newNode ( 9 );
        root.left.right.right.right = newNode ( 10 );

        printEvenLevelEvenNodes ( root );
    }

    static class Node {
        int data;
        Node left, right;
    }

}
