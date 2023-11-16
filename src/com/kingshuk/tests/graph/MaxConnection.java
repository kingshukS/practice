package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MaxConnection {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,0,1},{1,0,1}, {1,0,1}};
        System.out.println(new MaxConnection().MaxConnection(grid));
    }
    public int MaxConnection(int[][] grid) {
        int[][] DIRECTIONS = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int n = grid.length;
        DisjointSet disjointSet = new DisjointSet(n * n);
        List<Cell> listZeroes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0)
                {
                    listZeroes.add(new Cell(i,j));
                }else{
                    for(int[] dir : DIRECTIONS)
                    {
                        int ix = i + dir[0];
                        int jx = j + dir[1];
                        if(ix<0 || ix>=n || jx<0 || jx>=n || grid[ix][jx] == 0)
                            continue;
                        int node = i * n + j;
                        int adjNode = ix * n + jx;
                        if(disjointSet.find(node) != disjointSet.find(adjNode))
                        {
                            disjointSet.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(Cell cell : listZeroes)
        {
            int zeroX = cell.x;
            int zeroY = cell.y;
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            for(int[] dir : DIRECTIONS)
            {
                int ix = zeroX + dir[0];
                int jx = zeroY + dir[1];
                if(ix<0 || ix>=n || jx<0 || jx>=n || grid[ix][jx] == 0)
                    continue;
                int adjNode = ix * n + jx;
                int ultimateParent = disjointSet.find(adjNode);
                if(set.contains(ultimateParent)) continue;
                set.add(ultimateParent);
                ans += disjointSet.size[ultimateParent];
            }
            max = Math.max(max, ans+1);
        }

        for(int i = 0; i < disjointSet.size.length; i++)
        {
            max = Math.max(max, disjointSet.size[i]);
        }
        return max;
    }
}

class Cell {
    int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}