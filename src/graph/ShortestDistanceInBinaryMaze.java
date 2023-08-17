package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class ShortestDistanceInBinaryMaze {

    private static int[][] DIRCTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }
        distance[source[0]][source[1]] = 0;
        Queue<Triplet> queue = new ArrayDeque<>();
        queue.add(new Triplet(0, source[0], source[1]));

        // no need of PQ, unit directions in all 4 directions
        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            int sx = triplet.x;
            int sy = triplet.y;
            int sd = triplet.d;

            for (int[] dir : DIRCTIONS) {
                int rx = sx + dir[0];
                int ry = sy + dir[1];
                if (rx < 0 || rx >= n || ry < 0 || ry >= m || grid[rx][ry] == 0 || sd + 1 >= distance[rx][ry])
                    continue;
                distance[rx][ry] = sd + 1;
                queue.add(new Triplet(distance[rx][ry], rx, ry));
                if(rx == destination[0] && ry == destination[1])
                    return distance[rx][ry];
            }
        }
        return -1;
    }

    class Triplet {
        int d, x, y;

        public Triplet(int d, int x, int y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }
}

