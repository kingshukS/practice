package com.kingshuk.tests.DynamicProgramming;

public class MinimumJumpsBest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int size = arr.length;
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, size));
    }

    /**
     * Here is an improvement insight: From any jump point i, we can reach any index from(i + 1) to (i + A[i]),
     * and there will be some value between range A[i + 1] to A[i + A[i]], which can provide the farthest reach from that range.
     * So we define lower and upper end of the current jump point and calculate the farthest reach in that range.
     * whenever we reach the upper endpoint of a range, we update the upper end with the value of the farthest reach and increment jump count.
     * We continue this process till the value of the farthest reachable index is greater than or equal to n - 1.
     *
     * jump: To store the value of jump count
     * currStart and currEnd: To store the range of the current jump point.
     * currMaxReach: To store the farthest reach possible in the range [currStart, currEnd].
     *
     * We initialize jump to 0, currStart to 0, currEnd to 0, and currMaxReach to -1.
     * Next, we traverse the array from currStart = 1 to n - 2, updating currMaxReach as we go. Note that currStart will be less than n - 1,
     * because we don't need to jump again when we reach the last element of the array.
     * Once currStart equals currEnd, we trigger a jump and update the range of the next jump point. To update the range, we set the value of currEnd
     * to currMaxReach.
     * During the update of currMaxReach, we also need to check whether currMaxReach is greater than or equal to n - 1. If it is true,
     * we can directly reach the end of the array from the currStart by taking a single jump. So we increment the value of jump and break out of the loop.
     * At the end of the loop, we return the value stored in jump. If it is not reachable after exhausting currEnd, return -1 as unreachable output.
     *
     * @param arr
     * @param n
     * @return
     */
    private static int minJumps(int[] arr, int n) {
        int currStart = 0, currEnd = 0, currMaxReach = -1, jump = 0;
        while (currStart < n - 1) {
            currMaxReach = Math.max(currMaxReach, currStart + arr[currStart]);

            if (currMaxReach >= n - 1) {
                return jump + 1;
            }

            if (currStart == currEnd) {
                jump++;
                if (currMaxReach <= currEnd)
                    return -1;
                currEnd = currMaxReach;
            }
            currStart++;
        }
        return jump;
    }
}
