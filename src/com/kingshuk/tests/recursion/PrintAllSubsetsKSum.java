package com.kingshuk.tests.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// time complexity: O(2^n)
public class PrintAllSubsetsKSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1};
        int k = 2;
        List<List<Integer>> result = findAllSubsetsWithKSum1Output(arr, k);
        System.out.println(result);
    }

    private static List<List<Integer>> findAllSubsetsWithKSum1Output(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int index = 0;
        findAllSubsetsWithKSum1Output(arr, index, tempList, result, 0, k);
        return result;
    }

    private static void findAllSubsetsWithKSum(int[] arr, int index, List<Integer> tempList, List<List<Integer>> result, int curSum, int sum) {
        if (index == arr.length) {
            if (curSum == sum)
                result.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(arr[index]);
        curSum += arr[index];
        findAllSubsetsWithKSum(arr, index + 1, tempList, result, curSum, sum);
        tempList.remove(tempList.size() - 1);
        curSum -= arr[index];
        findAllSubsetsWithKSum(arr, index + 1, tempList, result, curSum, sum);
    }

    private static boolean findAllSubsetsWithKSum1Output(int[] arr, int index, List<Integer> tempList, List<List<Integer>> result, int curSum, int sum) {
        if (index == arr.length) {
            if (curSum == sum) {
                result.add(new ArrayList<>(tempList));
                return true;
            }
            return false;
        }
        tempList.add(arr[index]);
        curSum += arr[index];
        if (findAllSubsetsWithKSum1Output(arr, index + 1, tempList, result, curSum, sum))
            return true;
        tempList.remove(tempList.size() - 1);
        curSum -= arr[index];
        return findAllSubsetsWithKSum1Output(arr, index + 1, tempList, result, curSum, sum);
    }
}
