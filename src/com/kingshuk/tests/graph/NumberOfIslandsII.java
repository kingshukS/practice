package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.List;

class NumberOfIslandsII {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        int[][] DIRECTIONS = new int[][]{{0,-1},{0,1}, {-1,0}, {1,0}};
        DisjointSet disjointSet = new DisjointSet(rows * cols);
        int len = operators.length;
        int[][] vis = new int[rows][cols];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<len; i++)
        {
            int row = operators[i][0];
            int col = operators[i][1];

            if(vis[row][col] == 1)
            {
                ans.add(count);
                continue;
            }

            vis[row][col] = 1;
            count++;
            for(int[] dir : DIRECTIONS)
            {
                int adjR = row + dir[0];
                int adjC = col + dir[1];
                if(adjR <0 || adjR >= rows || adjC<0 || adjC>= cols || vis[adjR][adjC] == 0)
                    continue;
                int node = row * cols + col;
                int adjNode = adjR * cols + adjC;
                if(disjointSet.find(node) != disjointSet.find(adjNode))
                {
                    count--;
                    disjointSet.unionBySize(node, adjNode);
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
}