package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.List;

class Bridges {

    private int insertionTime = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(List<Integer> connection : connections)
        {
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(vis[i] == 0)
            {
                dfs(i, -1, vis, adjList, tin, low, bridges);
            }
        }

        return bridges;
    }

    private void dfs(int node, int parent, int[] vis, List<List<Integer>> adjList, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = insertionTime;
        insertionTime++;

        for(int it : adjList.get(node))
        {
            if(it == parent) continue;
            if(vis[it] == 0)
            {
                dfs(it, node, vis, adjList, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if(low[it]>tin[node])
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(node);
                    list.add(it);
                    bridges.add(list);
                }
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}