package com.kingshuk.tests.misc;

public class NumberOfClusters {

  final static int[] offsets = {-1, 0, +1};

  private boolean neighborExists(int[][] matrix, int i, int j)
 {
               if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length))
            {
                return matrix[i][j] == 1;
           }

            return false;
      }

      private void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {
          if (visited[i][j]) {
              return;
          }


          visited[i][j] = true;

          int xOffset, yOffset;
          for (int l = 0; l < offsets.length; l++) {
              xOffset = offsets[l];
              for (int m = 0; m < offsets.length; m++) {
                  yOffset = offsets[m];


                  if (xOffset == 0 && yOffset == 0) {
                      continue;
                  }


                  if (neighborExists(matrix, i + xOffset, j + yOffset)) {
                      doDFS(matrix, i + xOffset, j + yOffset, visited);
                  }
              }
          }
      }

           public int findNumberofClusters(int[][] matrix)
   {

        	        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        	        int count = 0;
        	        for (int i = 0; i < matrix.length; i++)
        	        {
        	            for (int j = 0; j < matrix[0].length; j++)
        	            {
        	                if ((matrix[i][j] == 1) && (!visited[i][j]))
                        {

                            count += 1;
        	                    doDFS(matrix, i, j, visited);
        	                }
        	            }
        	        }
        	        return count;
        	    }


        	    public static void main(String[] args)
{
              int[][] matrix = {
                                        {1,1,1,1,0},
                                           {1,1,0,1,0},
                                          {1,1,0,0,0},
                                          {0,0,0,0,0}
                               };

        	        NumberOfClusters solution = new NumberOfClusters();

        	        System.out.println(solution.findNumberofClusters(matrix));
        	    }
}
