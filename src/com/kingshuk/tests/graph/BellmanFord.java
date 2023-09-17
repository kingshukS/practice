package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;

        for(int i = 0; i<V-1; i++)
        {
            for(ArrayList<Integer> edge : edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if(dist[u] != (int)1e8 && dist[u]+weight < dist[v])
                {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for(ArrayList<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if(dist[u] != (int)1e8 && dist[u]+weight < dist[v])
            {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
