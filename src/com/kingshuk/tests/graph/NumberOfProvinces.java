package com.kingshuk.tests.graph;

import java.util.ArrayList;

class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int numberOfProvinces = 0;
        for (int i = 0; i <V; i++)
        {
            if(ds.parents[i] == i)
            {
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }
}