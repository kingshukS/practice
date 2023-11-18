package com.kingshuk.tests.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CostToCutChocolate {
    public static int cost(int n, int c, int cuts[]) {
        List<Integer> list = Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0);
        list.add(n);
        Collections.sort(list);

        return f(1, c, list);
    }

    public static int costMemoization(int n, int c, int cuts[]) {
        List<Integer> list = Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0);
        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(1, c, list, dp);
    }

    public static int costTabulation(int n, int c, int cuts[]) {
        List<Integer> list = Arrays.stream(cuts).boxed().collect(Collectors.toList());
        list.add(0);
        list.add(n);
        Collections.sort(list);

        int[][] dp = new int[c + 2][c + 2];

        for(int i = c; i>=1; i--)
        {
            for(int j = i; j <= c; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = i; k<=j; k++)
                {
                    min = Math.min(min, dp[i] [k-1] + dp[k+1] [j] + list.get(j+1)-list.get(i-1));
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    private static int f(int i, int j, List<Integer> list, int[][] dp) {
        if(i>j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++)
        {
            min = Math.min(min, f(i, k-1, list, dp) + f(k+1, j, list, dp) + list.get(j+1)-list.get(i-1));
        }
        return dp[i][j] = min;
    }

    private static int f(int i, int j, List<Integer> cuts) {
        if (i > j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                    f(i, ind - 1, cuts) +
                    f(ind + 1, j, cuts);

            mini = Math.min(mini, ans);
        }

        return mini;
    }

}