package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.List;

class EventualSafeNodes {
    List<Integer> eventualSafeNodes ( int V, List<List<Integer>> adj ) {
        int[] safe = new int[V];
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] == 0 ) {
                dfs ( i, vis, pathVis, safe, adj );
            }
        }

        List<Integer> list = new ArrayList<> ();
        for ( int i = 0; i < V; i++ ) {
            if ( safe[i] == 1 )
                list.add ( i );
        }
        return list;
    }

    private boolean dfs ( int node, int[] vis, int[] pathVis, int[] safe, List<List<Integer>> adj ) {
        vis[node] = 1;
        pathVis[node] = 1;

        for ( int x : adj.get ( node ) ) {
            if ( vis[x] == 0 ) {
                if ( dfs ( x, vis, pathVis, safe, adj ) )
                    return true;
            } else {
                if ( pathVis[x] == 1 )
                    return true;
            }
        }
        pathVis[node] = 0;
        safe[node] = 1;

        return false;
    }
}