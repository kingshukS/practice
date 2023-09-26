package com.kingshuk.tests.Important;

/*
        Let s = sum(nums),
        n = size(nums),
        m = min moves,
        f = final state of all nums[i]

        In each move, s increments by n - 1, so in m moves it'd increment by k - 1, and the final sum will be ke
        s + m(n - 1) = nf ... (1)

        The minimum element will go through m moves, i.e.
        min + m = f ... (2)

        Put (2) in (1)

        s + m(n - 1) = n(min + m)
        ⇒ s - m = n x min
        ⇒ m = s - n x min
 */
public class MinimumMovesToMakeAllElementsEqual {

    public int minMoves(int[] nums) {
        int sum = 0, min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(nums[i], min);
        }
        return sum - nums.length * min;
    }
}
