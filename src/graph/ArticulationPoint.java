package graph;

import java.util.*;
import java.util.stream.Collectors;

class ArticulationPoint {
    private int insertionTime = 1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < V; i++){
            if(vis[i] == 0)
            {
                dfs(i, -1, vis, adj, tin, low, mark);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i< V; i++)
        {
            if(mark[i] == 1)
                res.add(i);
        }
        if(res.size() == 0)
            res.add(-1);
        return res;
    }

    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, int[] mark) {
        vis[node] = 1;
        tin[node] = low[node] = insertionTime;
        insertionTime++;
        int child = 0;

        for(int it : adj.get(node))
        {
            if(it == parent) continue;
            if(vis[it] == 0)
            {
                dfs(it, node, vis, adj, tin, low, mark);
                low[node] = Math.min(low[node], low[it]);
                if(low[it]>=tin[node] && parent != -1)
                {
                    mark[node] = 1;
                }
                child++;
            }else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if(child>1 && parent == -1)
        {
            mark[node] = 1;
        }
    }
}