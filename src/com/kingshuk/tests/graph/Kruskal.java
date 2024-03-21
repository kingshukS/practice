package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Kruskal {

    public static void main ( String[] args ) {
        int[][] edges = new int[][]{ { 0, 1, 5 } };
        System.out.println ( spanningTree ( 2, 1, edges ) );
    }

    static int spanningTree ( int V, int E, int[][] edges ) {
        List<Edge> edgeList = new ArrayList<> ();

        for ( int i = 0; i < E; i++ ) {
            edgeList.add ( new Edge ( edges[i][0], edges[i][1], edges[i][2] ) );
        }

        Collections.sort ( edgeList );
        DisjointSet ds = new DisjointSet ( V );
        int mstWt = 0;
        for ( int i = 0; i < edgeList.size (); i++ ) {
            Edge edge = edgeList.get ( i );
            int wt = edge.wt;
            int u = edge.u;
            int v = edge.v;

            if ( ds.find ( u ) != ds.find ( v ) ) {
                mstWt += wt;
                ds.unionBySize ( u, v );
            }
        }
        return mstWt;
    }

    static class Edge implements Comparable<Edge> {
        int u, v, wt;

        public Edge ( int u, int v, int wt ) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo ( Edge e ) {
            return this.wt - e.wt;
        }
    }
}