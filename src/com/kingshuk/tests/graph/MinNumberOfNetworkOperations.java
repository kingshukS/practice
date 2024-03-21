package com.kingshuk.tests.graph;

class MinNumberOfNetworkOperations {

    public int Solve ( int n, int[][] edges ) {
        DisjointSet ds = new DisjointSet ( n );
        int extraEdge = 0;
        for ( int[] edge : edges ) {
            int u = edge[0];
            int v = edge[1];
            if ( ds.find ( u ) == ds.find ( v ) ) {
                extraEdge++;
            } else {
                ds.unionBySize ( u, v );
            }
        }
        int numOfComponents = 0;
        for ( int i = 0; i < n; i++ ) {
            if ( ds.parents[i] == i ) {
                numOfComponents++;
            }
        }
        int edgeRequired = numOfComponents - 1;
        if ( edgeRequired > extraEdge ) {
            return - 1;
        }
        return edgeRequired;
    }
}