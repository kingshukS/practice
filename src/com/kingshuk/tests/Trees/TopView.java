package com.kingshuk.tests.Trees;

import java.util.*;

public class TopView {
    NodeT root;

    public TopView ( NodeT node ) {
        root = node;
    }

    public static void main ( String[] args ) {
        NodeT root = new NodeT ( 1 );
        root.left = new NodeT ( 2 );
        root.right = new NodeT ( 3 );
        root.left.left = new NodeT ( 4 );
        root.left.right = new NodeT ( 5 );
        root.right.left = new NodeT ( 6 );
        root.right.right = new NodeT ( 7 );
        //     root.left.left.left = new NodeT(6);
        TopView tree = new TopView ( root );
        System.out.println ( "Top view of the given binary tree:" );
        tree.topView ();
    }

    public void topView () {
        if ( root == null )
            return;
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<> ();
        Queue<NodeT> queue = new LinkedList<NodeT> ();

        root.hd = hd;
        queue.add ( root );

        while (! queue.isEmpty ()) {
            NodeT temp = queue.remove ();

            hd = temp.hd;
            if ( ! map.containsKey ( temp.hd ) ) {
                map.put ( hd, temp.data );
            }

            if ( temp.right != null ) {
                temp.right.hd = hd + 1;
                queue.add ( temp.right );
            }
            if ( temp.left != null ) {
                temp.left.hd = hd - 1;
                queue.add ( temp.left );
            }

        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet ();

        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator ();

        while (iterator.hasNext ()) {
            Map.Entry<Integer, Integer> me = iterator.next ();
            System.out.print ( me.getValue () + " " );
        }
    }
}
