package com.kingshuk.tests.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class RottingOranges {
    int[][] add = {{0,-1}, {0,1},{-1, 0}, {1, 0}};
    class Tuple{
        int x, y, t;
        Tuple(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.t = time;
        }

    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int time = 0;
        Queue<Tuple> queue = new ArrayDeque<>();
        for(int i = 0; i< n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new Tuple(i, j, 0));
                }else if(grid[i][j] == 1)
                    count++;
            }
        }

        while(!queue.isEmpty()){
            Tuple tux = queue.poll();
            int ix = tux.x;
            int jx = tux.y;
            int tx = tux.t;
            time = Math.max(time, tx);
            grid[ix][jx] = 2;
            for(int[] x : add)
            {
                int newI = ix + x[0];
                int newJ = jx+ x[1];
                if(newI<0 || newI>= n || newJ<0 || newJ>= m || grid[newI][newJ] != 1)
                    continue;
                grid[newI][newJ] = 2;
                queue.add(new Tuple(newI, newJ, tx+1));
                count--;
            }
        }

         return count == 0? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        System.out.println(new RottingOranges().orangesRotting(grid));
    }
}