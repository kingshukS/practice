package com.kingshuk.tests.DynamicProgramming;

public class NinjaTraining {
    // public static int ninjaTraining(int n, int points[][]) {

    //     // Write your code here..
    //     int[][] dp = new int[n][4];
    //     for(int i = 0; i<n; i++)
    //         for(int j = 0; j<4; j++)
    //             dp[i][j] = -1;
    //     return ninjaTrainingutil(n-1, 3, points, dp);
    // }

    private static int ninjaTrainingutil(int index, int prev, int[][] points, int[][] dp) {
        int max = 0;
        if (index == 0) {
            for (int task = 0; task <= 2; task++) {
                if (task != prev)
                    max = Math.max(points[0][task], max);
            }
            return dp[0][prev] = max;
        }

        if (dp[index][prev] != -1) return dp[index][prev];

        for (int task = 0; task <= 2; task++) {
            if (task != prev)
                max = Math.max(max, points[index][task] + ninjaTrainingutil(index - 1, task, points, dp));
        }
        return dp[index][prev] = max;
    }

    // public static int ninjaTraining(int n, int points[][]) {

    //     // Write your code here..
    //     // base case
    //     int[][] dp = new int[n][4];
    //     dp[0][0] = Math.max(points[0][1], points[0][2]);
    //     dp[0][1] = Math.max(points[0][0], points[0][2]);
    //     dp[0][2] = Math.max(points[0][0], points[0][1]);
    //     dp[0][3] = Math.max(points[0][0], Math.max(points[0][1],points[0][2]));

    //     for(int day = 1; day<n; day++)
    //     {
    //         for(int prev = 0; prev<=3; prev++)
    //         {
    //             dp[day][prev] = 0;
    //             for(int task = 0; task<=2; task++)
    //             {
    //                 if(task != prev)
    //                     dp[day][prev] = Math.max(dp[day][prev], points[day][task]+dp[day-1][task]);
    //             }
    //         }
    //     }

    //     return dp[n-1][3];
    // }

    public static int ninjaTraining(int n, int[][] points) {
        // base case
        int[] merit = new int[4];
        merit[0] = Math.max(points[0][1], points[0][2]);
        merit[1] = Math.max(points[0][0], points[0][2]);
        merit[2] = Math.max(points[0][0], points[0][1]);
        merit[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int prev = 0; prev <= 3; prev++) {
                temp[prev] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != prev)
                        temp[prev] = Math.max(temp[prev], points[day][task] + merit[task]);
                }
            }
            merit = temp;
        }
        return merit[3];
    }
}