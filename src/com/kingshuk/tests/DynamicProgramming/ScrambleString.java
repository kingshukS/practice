package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(2^k + 2^(n-k)), where k and n-k are the length of the two substrings.
 * Auxiliary Space: O(2^N), recursion stack.
 */
public class ScrambleString {
    public static final String SEPARATOR = "$";
    static Map<String, Boolean> scrambleMap = new HashMap<> ();

    public static void main ( String[] args ) {
        String a = "great";
        String b = "gerta";
        long startTime = System.nanoTime ();
        System.out.println ( "Are they scrambled?(T/F) :" + isScramble ( a, b ) );
        long endTime = System.nanoTime ();
        System.out.println ( "Duration:" + ( endTime - startTime ) );
    }

    private static boolean isScramble ( String a, String b ) {
        int n = a.length ();
        if ( a.length () != b.length () ) {
            scrambleMap.put ( a + SEPARATOR + b, false );
            return false;
        }
        if ( a.equals ( b ) ) {
            scrambleMap.put ( a + SEPARATOR + b, true );
            return true;
        }
        if ( scrambleMap.containsKey ( a + SEPARATOR + b ) )
            return scrambleMap.get ( a + SEPARATOR + b );

        /* Anagram check*/
        char[] aCharArray = a.toCharArray ();
        char[] bCharArray = b.toCharArray ();
        Arrays.sort ( aCharArray );
        Arrays.sort ( bCharArray );
        String s1 = new String ( aCharArray );
        String s2 = new String ( bCharArray );
        if ( ! s1.equals ( s2 ) ) {
            scrambleMap.put ( a + SEPARATOR + b, false );
            return false;
        }
        for ( int i = 1; i < n; i++ ) {
            boolean condSwapPart1 = scrambleMap.containsKey ( a.substring ( 0, i ) + SEPARATOR + b.substring ( n - i, n ) ) ?
                    scrambleMap.get ( a.substring ( 0, i ) + SEPARATOR + b.substring ( n - i, n ) ) : isScramble ( a.substring ( 0, i ), b.substring ( n - i, n ) );
            boolean condSwapPart2 = scrambleMap.containsKey ( a.substring ( i, n ) + SEPARATOR + b.substring ( 0, n - i ) ) ?
                    scrambleMap.get ( a.substring ( i, n ) + SEPARATOR + b.substring ( 0, n - i ) ) : isScramble ( a.substring ( i, n ), b.substring ( 0, n - i ) );
            boolean condNoSwapPart1 = scrambleMap.containsKey ( a.substring ( 0, i ) + SEPARATOR + b.substring ( 0, i ) ) ?
                    scrambleMap.get ( a.substring ( 0, i ) + SEPARATOR + b.substring ( 0, i ) ) : isScramble ( a.substring ( 0, i ), b.substring ( 0, i ) );
            boolean condNoSwapPart2 = scrambleMap.containsKey ( a.substring ( i, n ) + SEPARATOR + b.substring ( i, n ) ) ?
                    scrambleMap.get ( a.substring ( i, n ) + SEPARATOR + b.substring ( i, n ) ) : isScramble ( a.substring ( i, n ), b.substring ( i, n ) );
            boolean condSwap = condSwapPart1 && condSwapPart2;
            boolean condNoSwap = condNoSwapPart1 && condNoSwapPart2;
            if ( condSwap || condNoSwap ) {
                scrambleMap.put ( a + SEPARATOR + b, true );
                return true;
            }
        }
        scrambleMap.put ( a + SEPARATOR + b, false );
        return false;
    }
}
