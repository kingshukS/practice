package com.kingshuk.tests.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class SmallestNeighbourCityInThreshold {
    int findCity ( int n, int m, int[][] edges, int distanceThreshold ) {
        int[][] matrix = new int[n][n];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                matrix[i][j] = (int) 1e9;
            }
        }

        for ( int[] edge : edges ) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }

        for ( int i = 0; i < n; i++ )
            matrix[i][i] = 0;

        for ( int k = 0; k < n; k++ ) {
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < n; j++ ) {
                    matrix[i][j] = Math.min ( matrix[i][k] + matrix[k][j], matrix[i][j] );
                }
            }
        }

        int cityReachableMin = n;
        int cityNo = - 1;

        for ( int i = 0; i < n; i++ ) {
            int count = 0;
            for ( int j = 0; j < n; j++ ) {
                if ( matrix[i][j] <= distanceThreshold )
                    count++;
            }
            if ( count <= cityReachableMin ) {
                cityReachableMin = count;
                cityNo = i;
            }
        }

        return cityNo;
    }

    int findCityDijkstra ( int n, int m, int[][] edges, int distanceThreshold ) {
        int[][] matrix = new int[n][n];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                matrix[i][j] = (int) 1e9;
            }
        }

        for ( int[] edge : edges ) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }

        for ( int i = 0; i < n; i++ )
            matrix[i][i] = 0;

        for ( int i = 0; i < n; i++ ) {
            matrix[i] = applyDijkstra ( n, matrix, i );
        }


        int cityReachableMin = n;
        int cityNo = - 1;

        for ( int i = 0; i < n; i++ ) {
            int count = 0;
            for ( int j = 0; j < n; j++ ) {
                if ( matrix[i][j] <= distanceThreshold )
                    count++;
            }
            if ( count <= cityReachableMin ) {
                cityReachableMin = count;
                cityNo = i;
            }
        }

        return cityNo;
    }

    private int[] applyDijkstra ( int n, int[][] matrix, int S ) {
        int[] dist = new int[n];
        Arrays.fill ( dist, (int) 1e9 );
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<> ( Comparator.comparingInt ( ( a ) -> a.distance ) );
        pq.add ( new Pair ( S, 0 ) );

        while (! pq.isEmpty ()) {
            Pair pair = pq.poll ();
            int node = pair.node;
            int dis = pair.distance;

            for ( int i = 0; i < n; i++ ) {
                if ( matrix[node][i] != (int) 1e9 ) {
                    int nodeX = i;
                    int disX = matrix[node][i];

                    if ( dis + disX < dist[nodeX] ) {
                        dist[nodeX] = dis + disX;
                        pq.add ( new Pair ( nodeX, dist[nodeX] ) );
                    }
                }
            }
        }

        return dist;
    }

    static class Pair {
        int node, distance;

        public Pair ( int node, int distance ) {
            this.node = node;
            this.distance = distance;
        }
    }
}