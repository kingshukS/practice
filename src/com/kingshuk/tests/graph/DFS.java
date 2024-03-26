package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DFS {
    private static void dfs ( int s, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, int[] vis ) {
        vis[s] = 1;
        result.add ( s );
        for ( int nodeX : adj.get ( s ) ) {
            if ( vis[nodeX] != 1 )
                dfs ( nodeX, adj, result, vis );
        }
    }

    public ArrayList<Integer> dfsOfGraph ( int V, ArrayList<ArrayList<Integer>> adj ) {
        ArrayList<Integer> result = new ArrayList<> ();
        int[] vis = new int[V];
        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] != 1 )
                dfs ( i, adj, result, vis );
        }
        return result;
    }
}