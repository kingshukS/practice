package com.kingshuk.tests.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class PathWithMinimumEffort {

    private final int[][] DIRECTIONS = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    int MinimumEffort(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] efforts = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.e));
        pq.add(new Tuple(0, 0, 0));

        while(!pq.isEmpty())
        {
            Tuple t = pq.poll();
            int sx = t.x;
            int sy = t.y;
            int se = t.e;

            if(sx == n-1 && sy == m-1)
                return se;
            for(int[] dir : DIRECTIONS)
            {
                int rx = sx + dir[0];
                int ry = sy + dir[1];

                if(rx<0 || rx>=n || ry<0 || ry>=m)
                    continue;
                int re = Math.max(Math.abs(heights[rx][ry] - heights[sx][sy]), se);
                if(re < efforts[rx][ry])
                {
                    efforts[rx][ry] = re;
                    pq.add(new Tuple(rx, ry, re));
                }
            }
        }
        return -1;
    }

    class Tuple{
        int x, y, e;

        public Tuple(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new PathWithMinimumEffort().MinimumEffort(heights));
    }
}