package com.kingshuk.tests.graph;

import java.util.ArrayList;

class NumberOfProvincesII {
    static int numProvinces ( ArrayList<ArrayList<Integer>> adj, int V ) {

        // Convert adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<> ();
        for(int i = 0; i<V; i++)
            adjList.add ( new ArrayList<> () );
        for ( int i = 0; i < adj.size (); i++ ) {
            for ( int j = 0; j < adj.get ( i ).size (); j++ ) {
                if(i == j) continue;
                if ( adj.get ( i ).get ( j ) == 1 ) {
                    adjList.get ( i ).add ( j );
                    adjList.get ( j ).add ( i );
                }
            }
        }


        int count = 0;
        int[] vis = new int[V];
        for ( int i = 0; i < V; i++ ) {
            if(vis[i] == 0)
            {
                count++;
                traverse(i, adjList, vis);
            }
        }
        return count;
    }

    private static void traverse ( int node, ArrayList<ArrayList<Integer>> adj, int[] vis ) {
        vis[node] = 1;
        for(int nodeX : adj.get ( node ))
        {
            if(vis[nodeX] == 0)
                traverse ( nodeX, adj, vis );
        }
    }
}