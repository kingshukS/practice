package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.List;

class RatInMaze {
    private static final String[] DIRECTION_STRING= {"D", "L", "R", "U"};
    private static final int[][] DIRECTIONS = {{1,0}, {0,-1}, {0,1}, {-1,0}};
    public static ArrayList<String> findPath(int[][] m, int n) {
        List<String> path = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0] == 0)
            return res;
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        findPath(0, 0, m, n, path, res, vis);
        return res;
    }

    private static void findPath(int row, int col, int[][] m, int n, List<String> path, ArrayList<String> res, int[][] vis) {
        if(row == n-1 && col == n-1)
        {
            String pathX = String.join("", path);
            res.add(pathX);
            return;
        }

        for(int i = 0; i<DIRECTIONS.length; i++)
        {
            int rowX = row + DIRECTIONS[i][0];
            int colX = col + DIRECTIONS[i][1];

            if(rowX<0 || rowX>=n || colX<0 || colX>=n || vis[rowX][colX] == 1 || m[rowX][colX] == 0)
                continue;
            vis[rowX][colX] = 1;
            path.add(DIRECTION_STRING[i]);
            findPath(rowX, colX, m, n, path, res, vis);
            path.remove(path.size()-1);
            vis[rowX][colX] = 0;
        }
    }

    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(m, 4));
    }
}
