package com.kingshuk.tests.graph;

import java.util.HashSet;
import java.util.Set;

class MaxStoneRemoval {

    public static void main(String[] args) {
        int[][] stones = new int[][] {{0,0} ,{0,1}, {1,0} ,{1,2} ,{2,1} ,{2,2}};
        System.out.println(new MaxStoneRemoval().maxRemove(stones, 6));
    }
    int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for(int[] stone : stones)
        {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow+maxCol+2);
        Set<Integer> nodeSet = new HashSet<>();
        for(int i = 0; i<n; i++)
        {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + maxRow + 1;
            ds.unionBySize(rowNode, colNode);
            nodeSet.add(rowNode);
            nodeSet.add(colNode);
        }

        int componentCount = 0;
        for(int node : nodeSet)
        {
            if(ds.parents[node] == node)
                componentCount++;
        }

        return n - componentCount;
    }
}