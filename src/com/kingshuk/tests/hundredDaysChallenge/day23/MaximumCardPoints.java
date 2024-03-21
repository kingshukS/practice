package com.kingshuk.tests.hundredDaysChallenge.day23;

/**
 * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaximumCardPoints {

    public int maxScore ( int[] cardPoints, int k ) {
        int leftSum = 0;
        for ( int i = 0; i < k; i++ )
            leftSum += cardPoints[i];
        int rightSum = 0;
        int max = leftSum;
        int n = cardPoints.length;
        for ( int i = 0; i < k; i++ ) {
            leftSum = leftSum - cardPoints[k - 1 - i];
            rightSum = rightSum + cardPoints[n - 1 - i];
            max = Math.max ( max, leftSum + rightSum );
        }
        return max;
    }

    public int maxScoreWithTotalSum ( int[] cardPoints, int k ) {
        int total = 0, minSumArraySum = 0;
        int n = cardPoints.length;
        for ( int i = 0, curSum = 0; i < n; i++ ) {
            total += cardPoints[i];
            curSum += cardPoints[i];
            if ( i < n - k )
                minSumArraySum += cardPoints[i];
            else {
                curSum = curSum - cardPoints[i - ( n - k )];
                minSumArraySum = Math.min ( minSumArraySum, curSum );
            }
        }
        return total - minSumArraySum;
    }
}
