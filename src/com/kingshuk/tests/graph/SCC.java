package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.Stack;

class SCC
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<V; i++)
        {
            if(vis[i] == 0)
            {
                dfs(i, adj, vis, stack);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i<V; i++)
        {
            adjT.add(new ArrayList<>());
        }

        for(int i = 0; i<V; i++)
        {
            vis[i] = 0;
            for(int x : adj.get(i))
            {
                adjT.get(x).add(i);
            }
        }

        int scc = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(vis[node] == 0)
            {
                scc++;
                dsf(node, adjT, vis);
            }
        }
        return scc;
    }

    private void dsf(int node, ArrayList<ArrayList<Integer>> adjT, int[] vis) {
        vis[node] = 1;
        for(int x : adjT.get(node))
        {
            if(vis[x] == 0)
                dsf(x, adjT, vis);
        }
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for(int x : adj.get(node))
        {
            if(vis[x] == 0)
                dfs(x, adj, vis, stack);
        }
        stack.push(node);
    }
}