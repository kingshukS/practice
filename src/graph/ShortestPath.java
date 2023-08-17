package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class ShortestPath {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ShortestPath().shortestPath(6,7, new int[][]{{0, 1, 2},{0, 4, 1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}})));
	}
	public int[] shortestPath(int N,int M, int[][] edges) {
		
		List<List<Pair>> adj = new ArrayList<>();
		for(int i = 0; i<N; i++)
		    adj.add(new ArrayList<>());
		   
		for(int i = 0; i<M; i++)
		{
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] vis = new int[N];

		for(int i = 0; i<N; i++)
		{
			if(vis[i] == 0)
			{
				topologicalSort(i, adj, vis, stack);
			}
		}

		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;

		while(!stack.isEmpty()){
			int u = stack.pop();
			for(Pair p : adj.get(u))
			{
				int v = p.v;
				int wt = p.wt;
				if(distance[u]+wt < distance[v])
				{
					distance[v] = distance[u]+wt;
				}
			}
		}
		for(int i = 0; i<N; i++)
		{
			if(distance[i] == Integer.MAX_VALUE)
				distance[i] = -1;
		}
		return distance;
	}

	private void topologicalSort(int node, List<List<Pair>> adj, int[] vis, Stack<Integer> stack) {
		vis[node] = 1;
		for(Pair p : adj.get(node))
		{
			int v = p.v;
			if(vis[v] == 0)
			{
				topologicalSort(v, adj, vis, stack);
			}
		}
		stack.push(node);
	}

	class Pair{
	    int v, wt;
	    Pair(int _v, int _wt)
	    {
	        this.v = _v;
	        this.wt = _wt;
	    }
	}
}
