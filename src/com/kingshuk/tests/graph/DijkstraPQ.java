package com.kingshuk.tests.graph;

import java.util.*;

class DijkstraPQ {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra ( int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S ) {
        PriorityQueue<Pair> queue = new PriorityQueue<> ( Comparator.comparingInt ( a -> a.distance ) );
        int[] dis = new int[V];
        Arrays.fill ( dis, (int) 1e9 );
        dis[S] = 0;

        queue.add ( new Pair ( S, 0 ) );

        while (! queue.isEmpty ()) {
            Pair p = queue.poll ();
            int node = p.node;
            int weight = p.distance;

            for ( ArrayList<Integer> weightedEdge : adj.get ( node ) ) {
                int nodeX = weightedEdge.get ( 0 );
                int weightX = weightedEdge.get ( 1 );

                if ( weight + weightX < dis[nodeX] ) {
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