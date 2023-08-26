package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// time complexity: O(2^n)
public class PrintAllSubsets {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> result = findAllSubsets(arr, true);
        System.out.println(result);
    }

    private static List<List<Integer>> findAllSubsets(int[] arr, boolean byBit) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        if (!byBit) {
            int index = 0;
            findAllSubsets(arr, index, arr.length, tempList, result);
        } else {
            findAllSubsets(arr, arr.length, result);
        }
        Collections.sort(result, (o1, o2) ->
        {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) != o2.get(i)) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return o1.size() - o2.size();
        });
        return result;
    }

    private static void findAllSubsets(int[] arr, int n, List<List<Integer>> result) {

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tempList.add(arr[j]);
                }
            }
            result.add(tempList);
        }
    }

    private static void findAllSubsets(int[] arr, int index, int length, List<Integer> tempList, List<List<Integer>> result) {
        if (index == length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(arr[index]);
        findAllSubsets(arr, index + 1, length, tempList, result);
        tempList.remove(tempList.size() - 1);
        findAllSubsets(arr, index + 1, length, tempList, result);
    }
}
