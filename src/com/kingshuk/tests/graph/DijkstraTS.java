package com.kingshuk.tests.graph;

import java.util.*;

class DijkstraTS {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra ( int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S ) {
        TreeSet<Pair> queue = new TreeSet<> ( ( x, y ) -> x.distance == y.distance ? x.node - y.node : x.distance - y.distance );
        int[] dis = new int[V];
        Arrays.fill ( dis, (int) 1e9 );

        Set<Integer> set = new TreeSet<> ();
        dis[S] = 0;

        queue.add ( new Pair ( S, 0 ) );

        while (! queue.isEmpty ()) {
            Pair p = queue.pollFirst ();
            int node = p.node;
            int weight = p.distance;

            for ( ArrayList<Integer> weightedEdge : adj.get ( node ) ) {
                int nodeX = weightedEdge.get ( 0 );
                int weightX = weightedEdge.get ( 1 );

                if ( weight + weightX < dis[nodeX] ) {
                    if ( dis[nodeX] != (int) 1e9 ) {
                        queue.remove ( new Pair ( nodeX, dis[nodeX] ) );
                    }
                    dis[nodeX] = weight + weightX;
                    queue.add ( new Pair ( nodeX, dis[nodeX] ) );
                }
            }
        }

        return dis;
    }

    static class Pair {
        int node, distance;

        public Pair ( int node, int distance ) {
            this.node = node;
            this.distance = distance;
        }
    }
}