package com.kingshuk.tests.DynamicProgramming;// A Java solution for longest palindrome

class LongestPalindromeSubstring {

    // This function prints the
    // longest palindrome subString
    // It also returns the length
    // of the longest palindrome
    static int longestPalSubstr ( String str ) {
        // Get length of input string
        int n = str.length ();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean[][] table = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for ( int i = 0; i < n; ++ i )
            table[i][i] = true;

        // Check for sub-string of length 2.
        int start = 0;
        for ( int i = 0; i < n - 1; ++ i ) {
            if ( str.charAt ( i ) == str.charAt ( i + 1 ) ) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for ( int k = 3; k <= n; ++ k ) {

            // Fix the starting index
            for ( int i = 0; i < n - k + 1; ++ i ) {

                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // Checking for sub-string from ith index to
                // jth index if str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if ( table[i + 1][j - 1]
                        && str.charAt ( i ) == str.charAt ( j ) ) {
                    table[i][j] = true;

                    if ( k > maxLength ) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        System.out.print (
                "Longest palindrome substring is: " + str.substring ( start, start + maxLength ) );

        // Return length of LPS
        return maxLength;
    }

    public static void main ( String[] args ) {
        String str = "forgeeksskeegfor";
        System.out.print ( "\nLength is: "
                + longestPalSubstr ( str ) );
    }
}
