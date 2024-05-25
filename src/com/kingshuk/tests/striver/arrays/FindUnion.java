package com.kingshuk.tests.striver.arrays;

import java.util.ArrayList;

class FindUnion {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != arr1[i])
                    res.add(arr1[i]);
                i++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != arr2[j])
                    res.add(arr2[j]);
                j++;
            }
        }

        while (i < n) {
            if (res.isEmpty() || res.get(res.size() - 1) != arr1[i])
                res.add(arr1[i]);
            i++;
        }
        while (j < m) {
            if (res.isEmpty() || res.get(res.size() - 1) != arr2[j])
                res.add(arr2[j]);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {-7, 8};
        int[]  arr2 = {-8, -3, 8};
        System.out.println(findUnion(arr1, arr2,2, 3 ));
    }
}