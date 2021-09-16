package com.kingshuk.tests.sorting;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] a = {2, 10, 20, 20, 40, 60,80,80,80,100};
        int[] b = {10, 20, 20, 20, 60};
        printUnionElements(a, b);
    }

    /**
     * Union of 2 arrays excluding duplicates
     *
     * @param a First array
     * @param b Second array
     */
    public static void printUnionElements(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if(a[i]<b[j])
            {
                System.out.print(a[i]+" ");
                i++;
            }else if(a[i]>b[j])
            {
                System.out.print(b[j]+" ");
                j++;
            }else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }
        while (i < n1) {
            if(i>0 && a[i]!=a[i-1]) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
        while (j < n2) {
            if(j>0 && b[j]!=b[j-1]) {
                System.out.print(b[j] + " ");
            }
            j++;
        }
    }
}
