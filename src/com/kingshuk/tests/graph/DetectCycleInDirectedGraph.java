package com.kingshuk.tests.graph;

/*Complete the function below*/

import java.util.ArrayList;

class DetectCycleInDirectedGraph {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic ( int V, ArrayList<ArrayList<Integer>> adj ) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] == 0 ) {
                if ( dfs ( i, vis, pathVis, adj ) )
                    return true;
            }
        }

        return false;
    }

    private boolean dfs ( int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj ) {
        vis[node] = 1;
        pathVis[node] = 1;

        for ( int x : adj.get ( node ) ) {
            if ( vis[x] == 0 ) {
                if ( dfs ( x, vis, pathVis, adj ) )
                    return true;
            } else {
                if ( pathVis[x] == 1 )
                    return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}