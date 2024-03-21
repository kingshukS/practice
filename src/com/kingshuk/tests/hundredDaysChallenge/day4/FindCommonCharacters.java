package com.kingshuk.tests.hundredDaysChallenge.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FindCommonCharacters {
    public static void main ( String[] args ) {
        String[] words = { "bella", "label", "roller" };
        List<String> commonChars = findCommonChars ( words );
        commonChars.stream ().forEach ( System.out::println );
    }

    private static List<String> findCommonChars ( String[] words ) {
        int[] count = new int[26];
        Arrays.fill ( count, Integer.MAX_VALUE );
        for ( String word : words ) {
            int[] chars = new int[26];
            word.chars ().forEach ( i -> ++ chars[i - 'a'] );
            IntStream.range ( 0, 26 ).forEach ( i -> count[i] = Math.min ( count[i], chars[i] ) );
        }
        List<String> result = new ArrayList<> ();
        IntStream.range ( 0, 26 ).forEach ( i -> result.addAll ( Collections.nCopies ( count[i], "" + (char) ( i + 'a' ) ) ) );
        return result;
    }
}
