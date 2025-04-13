package com.kingshuk.tests.strings;

/**
 * This class provides a method to determine if one string can be transformed into another
 * by moving 'L' and 'R' characters while ignoring 'x' characters.
 */
public class StringTransform {

    public static boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;

        // Step 1: Remove all 'x' and check if relative order of 'L' and 'R' is same
        // Early-out optimization for invalid cases, not required in the final solution
        String startFiltered = start.replaceAll("x", "");
        String endFiltered = end.replaceAll("x", "");
        if (!startFiltered.equals(endFiltered)) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip 'x' in both strings
            while (i < n && start.charAt(i) == 'x') i++;
            while (j < n && end.charAt(j) == 'x') j++;

            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            char c1 = start.charAt(i);
            char c2 = end.charAt(j);

            if (c1 != c2) return false;

            // Check movement validity
            if (c1 == 'L' && j > i) return false; // L can only move left
            if (c1 == 'R' && i > j) return false; // R can only move right

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        String start = "RxxL";
        String end = "xRLx";
        System.out.println(canTransform(start, end)); // Output: true
    }
}
