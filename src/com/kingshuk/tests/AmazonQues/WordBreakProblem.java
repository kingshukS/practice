package com.kingshuk.tests.AmazonQues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays", "dynamic", "heaps", "Deserve", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"));

    public static boolean hasValidWords(String words) {

        // Empty string
        if(words == null || words.length() == 0) {
            return true;
        }

        int n = words.length();
        boolean[] validWords = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dictionary.contains(words.substring(0, i + 1))) {
                validWords[i] = true;
            }
            if (validWords[i] == true && (i == n - 1))
                return true;
            if (validWords[i] == true) {
                for (int j = i + 1; j < n; j++) {
                    if (dictionary.contains(words.substring(i + 1, j + 1))) {
                        validWords[j] = true;
                    }
                    if (j == n - 1 && validWords[j] == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (hasValidWords("Deservelearningplatform"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
