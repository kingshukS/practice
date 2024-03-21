package com.kingshuk.tests.Trees;

import java.util.*;

public class KDistanceNodeBFS {
    public static void main ( String[] args ) {
        TreeNode root = new TreeNode ( 20 );
        root.left = new TreeNode ( 8 );
        root.right = new TreeNode ( 22 );
        root.left.left = new TreeNode ( 4 );
        root.left.right = new TreeNode ( 12 );
        root.left.right.left = new TreeNode ( 10 );
        root.left.right.right = new TreeNode ( 14 );
        TreeNode target = root.left;
        printKDistanceNodeBFS ( root, target, 2 );
    }

    private static void printKDistanceNodeBFS ( TreeNode root, TreeNode target, int k ) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<> ();
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add ( root );
        while (! queue.isEmpty ()) {
            TreeNode node = queue.poll ();
            if ( node.left != null ) {
                parentMap.put ( node.left, node );
                queue.add ( node.left );
            }
            if ( node.right != null ) {
                parentMap.put ( node.right, node );
                queue.add ( node.right );
            }
        }

        int min = 0;
        Set<TreeNode> visited = new HashSet<> ();
        Queue<TreeNode> traverse = new LinkedList<> ();
        traverse.add ( target );
        visited.add ( target );
        while (! traverse.isEmpty ()) {
            if ( min == k )
                break;
            int size = traverse.size ();
            while (size > 0) {
                TreeNode node = traverse.poll ();
                if ( node.left != null && ! visited.contains ( node.left ) ) {
                    traverse.add ( node.left );
                    visited.add ( node.left );
                }
                if ( node.right != null && ! visited.contains ( node.right ) ) {
                    traverse.add ( node.right );
                    visited.add ( node.right );
                }
                if ( parentMap.get ( node ) != null && ! visited.contains ( parentMap.get ( node ) ) ) {
                    traverse.add ( parentMap.get ( node ) );
                    visited.add ( parentMap.get ( node ) );
                }
                size--;
            }
            min++;
        }

        while (! traverse.isEmpty ()) {
            TreeNode node = traverse.poll ();
            System.out.println ( node.data );
        }
    }
}
