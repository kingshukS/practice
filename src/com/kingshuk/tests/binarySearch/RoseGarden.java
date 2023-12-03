package com.kingshuk.tests.binarySearch;

public class RoseGarden {
    public static int roseGarden(int[] arr, int r, int b) {

        int[] maxArray = findMax(arr);
        int low = maxArray[0];
        int high = maxArray[1];

        int mid;
        int ans = -1;
        boolean res;

        while (low <= high) {
            mid = low + (high - low) / 2;
            res = f(arr, r, b, mid);
            // not possible
            if (!res) {
                low = mid + 1;

            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean f(int[] arr, int r, int b, int m) {
        int rc = r;
        for (int x : arr) {
            if (x <= m)
                rc--;
            else
                rc = r;
            if (rc == 0) {
                b--;
                rc = r;
            }
            if (b == 0) {
                return true;
            }
        }
        return false;
    }

    private static int[] findMax(int[] a) {
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int e : a) {
            max = Math.max(max, e);
            min = Math.min(min, e);
        }
        ans[0] = min;
        ans[1] = max;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,1 ,2 ,7 ,2 ,2 ,3 ,1};
        System.out.println(roseGarden(arr, 3, 2));
    }
}
