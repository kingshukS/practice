package com.kingshuk.tests.AmazonQues;

import java.util.*;

public class CriticalRouters2 {
    public static void main ( String[] args ) {
        CriticalRouters2 obj = new CriticalRouters2 ();

        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6 }, { 3, 4 } };

        List<Integer> res = obj.getCriticalRouters ( numRouters1, numLinks1, links1 );

        for ( int i : res ) System.out.print ( i + " " );
        System.out.println ();

        int numRouters2 = 5;
        int numLinks2 = 5;
        int[][] links2 = { { 1, 2 }, { 0, 1 }, { 2, 0 }, { 0, 3 }, { 3, 4 } };

        List<Integer> res2 = obj.getCriticalRouters ( numRouters2, numLinks2, links2 );
        for ( int i : res2 )// System.out.print(i + " ");
            System.out.println ();

        int numRouters3 = 4;
        int numLinks3 = 4;
        int[][] links3 = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

        List<Integer> res3 = obj.getCriticalRouters ( numRouters3, numLinks3, links3 );
        for ( int i : res3 ) //System.out.print(i + " ");
            System.out.println ();

        int numRouters4 = 7;
        int numLinks4 = 8;
        int[][] links4 = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 6 }, { 3, 5 }, { 4, 5 } };

        List<Integer> res4 = obj.getCriticalRouters ( numRouters4, numLinks4, links4 );
        for ( int i : res4 ) //System.out.print(i + " ");
            System.out.println ();
    }

    public List<Integer> getCriticalRouters ( int numNodes, int numEdges, int[][] edges ) {

        //construct com.kingshuk.tests.graph
        Map<Integer, Set<Integer>> graph = new HashMap<> ();

        //initialize com.kingshuk.tests.graph
        for ( int i = 0; i < numNodes; i++ ) graph.put ( i, new HashSet<> () );

        //add edges to com.kingshuk.tests.graph
        for ( int[] edge : edges ) {
            int u = edge[0];
            int v = edge[1];

            graph.get ( u ).add ( v );
            graph.get ( v ).add ( u );
        }

        List<Integer> result = new ArrayList<> ();

        //calculate critical routers
        for ( int nodeToRemove = 0; nodeToRemove < numNodes; nodeToRemove++ ) {

            //remove each node and its edges and check if entire com.kingshuk.tests.graph is connected
            Set<Integer> nodeEdges = graph.get ( nodeToRemove );
            int source = 0;
            for ( int edge : nodeEdges ) {
                graph.get ( edge ).remove ( nodeToRemove );
                source = edge;
            }

            HashSet<Integer> visited = new HashSet<> ();
            dfs ( graph, source, visited );

            if ( visited.size () != numNodes - 1 ) {
                //this node was a critical router
                result.add ( nodeToRemove );
            }

            //add the edges back
            for ( int edge : nodeEdges ) graph.get ( edge ).add ( nodeToRemove );
        }
        return result;
    }

    public void dfs ( Map<Integer, Set<Integer>> graph, int source, Set<Integer> visited ) {
        if ( visited.contains ( source ) ) return;

        visited.add ( source );

        for ( int child : graph.get ( source ) ) dfs ( graph, child, visited );
    }
}
