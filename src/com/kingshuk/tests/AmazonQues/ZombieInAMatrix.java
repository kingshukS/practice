package com.kingshuk.tests.AmazonQues;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInAMatrix {
    private static int minDays ( int[][] grid ) {
        Queue<int[]> q = new LinkedList<> ();
        if ( grid == null || grid.length <= 0 || grid[0].length <= 0 )
            return - 1;
        int target = grid.length * grid[0].length; //here 5 * 4(calculating the no. of cells
        int cnt = 0, res = 0; //cnt is the count zombie cells // result stores the number of hours/turns

        for ( int i = 0; i < grid.length; i++ ) { // rows
          /*  if(cnt == q.size())
            {
               break;
            }*/
            for ( int j = 0; j < grid[0].length; j++ ) { //no. of cells in each row
                if ( grid[i][j] == 1 ) {
                    //if cell has value 1
                    // ie it is a zombie ,add the location of cell in the queue and inc count of zombie
                    q.offer ( new int[]{ i, j } );
                    cnt++;
                }
            }
        }
        int[][] dirs = { { 0, 1 }, { 0, - 1 }, { 1, 0 }, { - 1, 0 } };
        //this is for all the directions down,up,right,left resp
        while (! q.isEmpty ()) {
            int size = q.size ();
            if ( cnt == target ) //if count becomes equal to cell nos. ie all cells turned into zombies
                return res; //if even one human is left and not turned to zombie ,then result is -1
            for ( int i = 0; i < size; i++ ) { // queue has zombie indices ,now poll the queue
                int[] cur = q.poll ();
                for ( int[] dir : dirs ) { //for all the 4 directions
                    int ni = cur[0] + dir[0]; //adding direction index to queue element
                    int nj = cur[1] + dir[1];
                    if ( ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0 ) {
                        //checking if index calculated for direction is 0 ,
                        // then turn it to zombie and inc zombie cnt and add it to queue
                        cnt++;
                        q.offer ( new int[]{ ni, nj } );
                        grid[ni][nj] = 1;
                    }
                }
            }
            res++; //after calculating for all the elements of queue
            // inc result which means first round completed
            //if queue is still empty ,then repeat the procedure for remaining queue elements and inc round number
        }
        return - 1; //if all humans are not converted to zombies ,return -1
    }

    public static void main ( String[] args ) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        // int[][] grid = {};
        System.out.println ( minDays ( grid ) );
    }
}
