package com.kingshuk.tests.graph;

import java.util.*;

class PrintShortestPath {
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++)
        {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] parents = new int[n+1];
        int[] distances = new int[n+1];

        for(int i = 0; i<=n; i++)
        {
            parents[i] = i;
            distances[i] = (int)1e9;
        }
        distances[1] = 0;

        PriorityQueue<Pair> pairs = new PriorityQueue<>(Comparator.comparingInt(x -> x.d));
        pairs.add(new Pair(1, 0));

        while(!pairs.isEmpty())
        {
            Pair p = pairs.poll();
            int u = p.v;
            int d = p.d;

            for(Pair p1 : adjList.get(u))
            {
                int v = p1.v;
                int dx = p1.d;
                if(d + dx < distances[v])
                {
                    distances[v] = d+dx;
                    pairs.add(new Pair(v, distances[v]));
                    parents[v] = u;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(distances[n] == (int)1e9){
            path.add(-1);
            return path;
        }
        path.add(n);
        int node = parents[n];
        while(node != parents[node])
        {
            path.add(node);
            node = parents[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    static class Pair{
        int v, d;
        public Pair(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    
}