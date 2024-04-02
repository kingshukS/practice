package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BipartiteGraph {
    public boolean isBipartite ( int V, ArrayList<ArrayList<Integer>> adj ) {
        int[] color = new int[V];
        Arrays.fill ( color, - 1 );
        for ( int i = 0; i < V; i++ ) {
            if ( color[i] == - 1 ) {
                if ( ! bfs ( i, adj, color ) )
                    return false;
            }
        }
        return true;
    }

    private boolean bfs ( int node, ArrayList<ArrayList<Integer>> adj, int[] color ) {
        color[node] = 0;
        Queue<Integer> queue = new LinkedList<> ();
        queue.add ( node );

        while (! queue.isEmpty ()) {
            int n = queue.poll ();
            for ( int adjNode : adj.get ( n ) ) {
                if ( color[adjNode] == - 1 ) {
                    color[adjNode] = 1 - color[n];
                    queue.add ( adjNode );
                } else if ( color[adjNode] == color[n] )
                    return false;
            }
        }
        return true;
    }

    private boolean dfs ( int node, int c, int[] color, ArrayList<ArrayList<Integer>> adj ) {
        color[node] = c;

        for ( int x : adj.get ( node ) ) {
            if ( color[x] == - 1 ) {
                if ( ! dfs ( x, 1 - c, color, adj ) )
                    return false;
            } else {
                if ( color[x] == c )
                    return false;
            }
        }
        return true;
    }
}