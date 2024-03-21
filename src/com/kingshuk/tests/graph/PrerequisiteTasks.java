package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PrerequisiteTasks {
    static int[] findOrder ( int n, int m, ArrayList<ArrayList<Integer>> prerequisites ) {
        List<List<Integer>> adj = new ArrayList<> ();
        int[] indegrees = new int[n];

        for ( int i = 0; i < n; i++ ) {
            adj.add ( new ArrayList<> () );
        }

        for ( int i = 0; i < m; i++ ) {
            adj.get ( prerequisites.get ( i ).get ( 1 ) ).add ( prerequisites.get ( i ).get ( 0 ) );
        }

        for ( int i = 0; i < n; i++ ) {
            for ( int x : adj.get ( i ) ) {
                indegrees[x]++;
            }
        }

        Queue<Integer> q = new LinkedList<> ();

        for ( int i = 0; i < n; i++ ) {
            if ( indegrees[i] == 0 ) {
                q.add ( i );
            }
        }
        int[] res = new int[n];
        int i = 0;
        while (! q.isEmpty ()) {
            int z = q.poll ();
            res[i++] = z;
            for ( int x : adj.get ( z ) ) {
                indegrees[x]--;
                if ( indegrees[x] == 0 ) {
                    q.add ( x );
                }
            }
        }
        return i == n ? res : new int[0];
    }

    public boolean isPossible ( int N, int P, int[][] prerequisites ) {
        List<List<Integer>> adj = new ArrayList<> ();
        int[] indegrees = new int[N];

        for ( int i = 0; i < N; i++ ) {
            adj.add ( new ArrayList<> () );
        }

        for ( int i = 0; i < P; i++ ) {
            adj.get ( prerequisites[i][1] ).add ( prerequisites[i][0] );
        }

        for ( int i = 0; i < N; i++ ) {
            for ( int x : adj.get ( i ) ) {
                indegrees[x]++;
            }
        }

        Queue<Integer> q = new LinkedList<> ();

        for ( int i = 0; i < N; i++ ) {
            if ( indegrees[i] == 0 ) {
                q.add ( i );
            }
        }
        int count = 0;
        while (! q.isEmpty ()) {
            int z = q.poll ();
            count++;
            for ( int x : adj.get ( z ) ) {
                indegrees[x]--;
                if ( indegrees[x] == 0 ) {
                    q.add ( x );
                }
            }
        }

        if ( count == N ) return true;

        return false;
    }
}