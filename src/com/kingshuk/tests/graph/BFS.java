package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    private static void bfs ( int s, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, int[] vis ) {
        Queue<Integer> queue = new LinkedList<> ();
        queue.add ( s );
        vis[s] = 1;
        while (! queue.isEmpty ()) {
            int node = queue.poll ();
            result.add ( node );
            for ( int nodeX : adj.get ( node ) ) {
                if ( vis[nodeX] != 1 ) {
                    vis[nodeX] = 1;
                    queue.add ( nodeX );
                }
            }
        }
    }

    public ArrayList<Integer> bfsOfGraph ( int V, ArrayList<ArrayList<Integer>> adj ) {
        ArrayList<Integer> result = new ArrayList<> ();
        int[] vis = new int[V];
        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] != 1 )
                bfs ( i, adj, result, vis );
        }
        return result;
    }
}