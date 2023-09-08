package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Kruskal {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 5}};
        System.out.println(spanningTree(2, 1, edges));
    }

    static int spanningTree(int V, int E, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            edgeList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }

        Collections.sort(edgeList);
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            int wt = edge.wt;
            int u = edge.u;
            int v = edge.v;

            if (ds.find(u) != ds.find(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }

    static class Edge implements Comparable<Edge> {
        int u, v, wt;

        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }
}

class DisjointSet {
    int[] rank;
    int[] size;
    int[] parents;

    public DisjointSet(int v) {
        rank = new int[v];
        size = new int[v];
        parents = new int[v];
        Arrays.fill(size, 1);
        for (int i = 0; i < v; i++)
            parents[i] = i;
    }

    public void unionByRank(int u, int v) {
        if (u != v) {
            int parent_u = find(u);
            int parent_v = find(v);
            if (parent_u != parent_v) {
                if (rank[parent_u] < rank[parent_v]) {
                    parents[parent_u] = parent_v;
                } else if (rank[parent_v] < rank[parent_u]) {
                    parents[parent_v] = parent_u;
                } else {
                    parents[parent_v] = parent_u;
                    rank[parent_u]++;
                }
            }
        }
    }

    public void unionBySize(int u, int v) {
        if (u != v) {
            int parent_u = find(u);
            int parent_v = find(v);
            if (parent_u != parent_v) {
                if (size[parent_u] < size[parent_v]) {
                    parents[parent_u] = parent_v;
                    size[parent_v] += size[parent_u];
                } else {
                    parents[parent_v] = parent_u;
                    size[parent_u] += size[parent_v];
                }
            }
        }
    }

    public int find(int u) {
        if (u != parents[u])
            parents[u] = find(parents[u]);
        return parents[u];
    }
}