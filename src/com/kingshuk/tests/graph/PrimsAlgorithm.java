package com.kingshuk.tests.graph;

import java.util.*;

class PrimsAlgorithm {
	static int spanningTree(int V, int E, int edges[][]){
		List<List<List<Integer>>> adjList = new ArrayList<>();
		for(int i = 0; i<V; i++)
		{
			adjList.add(new ArrayList<>());
		}

		for(int[] edge : edges)
		{
			int u = edge[0];
			int v = edge[1];
			int w = edge[2];

			adjList.get(u).add(Arrays.asList(v, w));
			adjList.get(v).add(Arrays.asList(u, w));
		}

		PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt((t) -> t.wt));
		pq.add(new Tuple(0, -1, 0));

		int[] vis = new int[V];
		int sum = 0;
		List<List<Integer>> mst = new ArrayList<>();

		while(!pq.isEmpty())
		{
			Tuple t = pq.poll();
			int node = t.node;
			int parent = t.parent;
			int weight = t.wt;

			if(vis[node] == 1) continue;

			vis[node] = 1;
			if(parent != -1)
			{
				sum+=weight;
				mst.add(Arrays.asList(parent, node));
			}

			for(List<Integer> adjNode : adjList.get(node))
			{
				int nodeX = adjNode.get(0);
				int weightX = adjNode.get(1);

				if(vis[nodeX] == 1) continue;
				pq.add(new Tuple(nodeX, node, weightX));
			}
		}

		return sum;
	}

	static class Tuple{
		int node, parent, wt;

		public Tuple(int node, int parent, int wt) {
			this.node = node;
			this.parent = parent;
			this.wt = wt;
		}
	}
}