package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScrambleStringRecursiveDP {
    static Map<String, Boolean> scrambleMap = new HashMap<>();

    public static void main(String[] args) {
        String a = "great";
        String b = "gerta";
        long startTime = System.nanoTime();
        System.out.println("Are they scrambled?(T/F) :" + isScramble(a, b));
        long endTime = System.nanoTime();
        System.out.println("Duration:" + (endTime - startTime));
    }

    private static boolean isScramble(String a, String b) {
        int n = a.length();
        if (a.length() != b.length()) {
            scrambleMap.put(a + "$" + b, false);
            return false;
        }
        if (a.equals(b)) {
            scrambleMap.put(a + "$" + b, true);
            return true;
        }
        if(scrambleMap.containsKey(a + "$" + b))
            return scrambleMap.get(a + "$" + b);

        /* Anagram check*/
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);
        String s1 = new String(aCharArray);
        String s2 = new String(bCharArray);
        if (!s1.equals(s2)) {
            scrambleMap.put(a + "$" + b, false);
            return false;
        }
        for (int i = 1; i <= n - 1; i++) {
            boolean condSwapPart1 = scrambleMap.containsKey(a.substring(0, i) + "$" + b.substring(n - i, n)) ?
                    scrambleMap.get(a.substring(0, i) + "$" + b.substring(n - i, n)) : isScramble(a.substring(0, i), b.substring(n - i, n));
            boolean condSwapPart2 = scrambleMap.containsKey(a.substring(i, n) + "$" + b.substring(0, n - i)) ?
                    scrambleMap.get(a.substring(i, n) + "$" + b.substring(0, n - i)) :isScramble(a.substring(i, n), b.substring(0, n - i));
            boolean condNoSwapPart1 = scrambleMap.containsKey(a.substring(0, i) + "$" + b.substring(0, i)) ?
                    scrambleMap.get(a.substring(0, i) + "$" + b.substring(0, i)) : isScramble(a.substring(0, i), b.substring(0, i));
            boolean condNoSwapPart2 = scrambleMap.containsKey(a.substring(i, n) + "$" + b.substring(i, n)) ?
                    scrambleMap.get(a.substring(i, n) + "$" + b.substring(i, n)) : isScramble(a.substring(i, n), b.substring(i, n));
            boolean condSwap = condSwapPart1 && condSwapPart2;
            boolean condNoSwap = condNoSwapPart1 && condNoSwapPart2;
            if (condSwap || condNoSwap) {
                scrambleMap.put(a + "$" + b, true);
                return true;
            }
        }
        scrambleMap.put(a + "$" + b, false);
        return false;
    }
}
