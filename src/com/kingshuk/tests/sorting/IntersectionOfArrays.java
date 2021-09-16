package com.kingshuk.tests.sorting;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] a = {2, 10, 20, 20, 40, 60};
        int[] b = {10, 20, 20, 20, 60};
        printIntersectionElements(a, b);
    }

    /**
     * Intersection of 2 arrays excluding duplicates
     *
     * @param a First array
     * @param b Second array
     */
    public static void printIntersectionElements(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
    }
}
