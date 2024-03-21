package com.kingshuk.tests.graph;

import java.util.Arrays;

class DisjointSet {
    int[] rank;
    int[] size;
    int[] parents;

    public DisjointSet ( int v ) {
        rank = new int[v];
        size = new int[v];
        parents = new int[v];
        Arrays.fill ( size, 1 );
        for ( int i = 0; i < v; i++ )
            parents[i] = i;
    }

    public void unionByRank ( int u, int v ) {
        if ( u != v ) {
            int parent_u = find ( u );
            int parent_v = find ( v );
            if ( parent_u != parent_v ) {
                if ( rank[parent_u] < rank[parent_v] ) {
                    parents[parent_u] = parent_v;
                } else if ( rank[parent_v] < rank[parent_u] ) {
                    parents[parent_v] = parent_u;
                } else {
                    parents[parent_v] = parent_u;
                    rank[parent_u]++;
                }
            }
        }
    }

    public void unionBySize ( int u, int v ) {
        if ( u != v ) {
            int parent_u = find ( u );
            int parent_v = find ( v );
            if ( parent_u != parent_v ) {
                if ( size[parent_u] < size[parent_v] ) {
                    parents[parent_u] = parent_v;
                    size[parent_v] += size[parent_u];
                } else {
                    parents[parent_v] = parent_u;
                    size[parent_u] += size[parent_v];
                }
            }
        }
    }

    public int find ( int u ) {
        if ( u != parents[u] )
            parents[u] = find ( parents[u] );

        /*
        int x = u;
        while(x != parents[x])
        {
            x = parents[x];
        }
        return x;

        */
        return parents[u];
    }
}
