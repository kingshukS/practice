package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TopologicalSort {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort ( int V, ArrayList<ArrayList<Integer>> adj ) {
        // add your code here
        int[] indegrees = new int[V];
        for ( int i = 0; i < V; i++ ) {
            for ( int x : adj.get ( i ) ) {
                indegrees[x]++;
            }
        }

        Queue<Integer> queue = new LinkedList<> ();
        for ( int i = 0; i < V; i++ ) {
            if ( indegrees[i] == 0 )
                queue.add ( i );
        }

        int[] topo = new int[V];
        int index = 0;

        while (! queue.isEmpty ()) {
            int node = queue.poll ();
            topo[index++] = node;

            for ( int x : adj.get ( node ) ) {
                indegrees[x]--;
                if ( indegrees[x] == 0 )
                    queue.add ( x );
            }
        }
        return topo;
    }

    static int[] topoSortDFS ( int V, ArrayList<ArrayList<Integer>> adj ) {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<> ();
        for ( int i = 0; i < V; i++ ) {
            if ( vis[i] == 0 ) {
                dfs ( i, vis, stack, adj );
            }
        }

        int[] topo = new int[stack.size ()];
        int index = 0;
        while (stack.size () > 0) {
            topo[index++] = stack.pop ();
        }

        return topo;
    }

    private static void dfs ( int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj ) {
        vis[node] = 1;

        for ( int x : adj.get ( node ) ) {
            if ( vis[x] == 0 )
                dfs ( x, vis, stack, adj );
        }
        stack.push ( node );
    }
}