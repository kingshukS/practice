package com.kingshuk.tests.graph;

import java.util.*;

class CheapestFlight {

    public int CheapestFLight ( int n, int[][] flights, int src, int dst, int k ) {
        List<List<Pair>> adjList = new ArrayList<> ();
        for ( int i = 0; i < n; i++ ) {
            adjList.add ( new ArrayList<> () );
        }

        for ( int i = 0; i < flights.length; i++ ) {
            adjList.get ( flights[i][0] ).add ( new Pair ( flights[i][1], flights[i][2] ) );
        }

        int[] minCost = new int[n];
        Arrays.fill ( minCost, Integer.MAX_VALUE );

        minCost[src] = 0;
        Queue<TuplesFlight> queue = new ArrayDeque<> ();
        queue.add ( new TuplesFlight ( 0, src, 0 ) );

        while (! queue.isEmpty ()) {
            TuplesFlight flight = queue.poll ();
            int stops = flight.stops;
            int city = flight.city;
            int cost = flight.cost;

            if ( stops > k ) continue;

            for ( Pair pair : adjList.get ( city ) ) {
                int v = pair.v;
                int dCost = pair.cost;

                if ( cost + dCost < minCost[v] ) {
                    minCost[v] = cost + dCost;
                    queue.add ( new TuplesFlight ( stops + 1, v, minCost[v] ) );
                }
            }
        }
        if ( minCost[dst] == Integer.MAX_VALUE ) return - 1;
        return minCost[dst];
    }

    class Pair {
        int v, cost;

        public Pair ( int v, int cost ) {
            this.v = v;
            this.cost = cost;
        }
    }

    class TuplesFlight {
        int stops, city, cost;

        public TuplesFlight ( int stops, int city, int cost ) {
            this.stops = stops;
            this.city = city;
            this.cost = cost;
        }
    }
}