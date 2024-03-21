package com.kingshuk.tests.misc;

public class TestMinimumNumberOfJumpsDP {
    public static void main ( String[] args ) {
        int[] arr = { 1, 3, 6, 1, 0, 9 };
        int size = arr.length;
        System.out.println ( "Minimum number of jumps to reach end is " + minJumps ( arr, size ) );
    }

    private static int minJumps ( int[] arr, int size ) {
        int[] jumps = new int[size];
        jumps[size - 1] = 0;
        for ( int i = size - 2; i >= 0; i-- ) {
            if ( arr[i] == 0 )
                jumps[i] = Integer.MAX_VALUE;
            else if ( arr[i] + i >= size - 1 )
                jumps[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for ( int j = i + 1; j < size && j <= arr[i] + i; j++ ) {
                    if ( min > jumps[j] )
                        min = jumps[j];
                }
                if ( min == Integer.MAX_VALUE )
                    jumps[i] = Integer.MAX_VALUE;
                else
                    jumps[i] = min + 1;
            }
        }

        return jumps[0];
    }
}
