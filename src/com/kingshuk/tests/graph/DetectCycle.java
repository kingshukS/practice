package com.kingshuk.tests.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class DetectCycle {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle ( int V, ArrayList<ArrayList<Integer>> adj ) {
        // Code here
        int[] vis = new int[V];
        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] == 0 ) {
                if ( dfs ( i, - 1, vis, adj ) )
                    return true;
            }
        }
        return false;
    }

    private boolean dfs ( int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj ) {
        vis[node] = 1;

        for ( int x : adj.get ( node ) ) {
            if ( vis[x] == 0 ) {
                if ( dfs ( x, node, vis, adj ) )
                    return true;
            } else {
                if ( parent != x )
                    return true;
            }
        }
        return false;
    }

    private boolean bfs ( int node, int[] vis, ArrayList<ArrayList<Integer>> adj ) {
        Pair pair = new Pair ( - 1, node );
        Queue<Pair> queue = new ArrayDeque<> ();
        queue.add ( pair );
        vis[node] = 1;
        while (! queue.isEmpty ()) {
            Pair p = queue.poll ();
            int current = p.node;
            int parent = p.parent;

            for ( int an : adj.get ( current ) ) {
                if ( vis[an] == 0 ) {
                    queue.add ( new Pair ( current, an ) );
                    vis[an] = 1;
                } else {
                    if ( an != parent )
                        return true;
                }
            }
        }
        return false;
    }

    class Pair {
        int parent;
        int node;

        Pair ( int parent, int node ) {
            this.parent = parent;
            this.node = node;
        }
    }
}