package com.kingshuk.tests.hundredDaysChallenge.day2;

/**
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 * <p>
 * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x
 * is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
 * <p>
 * Return the earliest year with the maximum population
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birth(i) < death(i) <= 2050
 */
public class MaximumPopulationYear {
    public static void main ( String[] args ) {
        int[][] logs = { { 1950, 1961 }, { 1960, 1971 }, { 1970, 1981 } };
        int maxPopulationYear = findMaximumPopulationYear ( logs );
        System.out.println ( "Maximum Population Year: " + maxPopulationYear );
    }

    private static int findMaximumPopulationYear ( int[][] logs ) {
        int[] prefixSumPopulation = new int[101];
        for ( int[] log : logs ) {
            int birthYearFromBase = log[0] - 1950;
            int deathYearFromBase = log[1] - 1950;
            prefixSumPopulation[birthYearFromBase] += 1;
            prefixSumPopulation[deathYearFromBase] += - 1;
        }
        int maxPopulation = prefixSumPopulation[0];
        int maxPopulationYear = 0;
        for ( int i = 1; i < 101; i++ ) {
            prefixSumPopulation[i] = prefixSumPopulation[i] + prefixSumPopulation[i - 1];
            if ( prefixSumPopulation[i] > maxPopulation ) {
                maxPopulation = prefixSumPopulation[i];
                maxPopulationYear = i;
            }
        }
        return maxPopulationYear + 1950;
    }
}
