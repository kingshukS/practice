package com.kingshuk.tests.AmazonQues;

import java.util.*;

public class KMostFrequentWords {
    static String[] getMostFrequentCommonwords ( String[] reviews, String[] keywords, int k ) {
        Map<String, Integer> frequencies = new HashMap<> ();
        List<String> keywordList = Arrays.asList ( keywords ); //converting keyword to an array list

        for ( String review : reviews ) { //this loop runs for every sentence
            review = review.toLowerCase ();
            Set<String> encounteredWords = new HashSet<> ();
            //for each review sentence we are splitting words on the basis of space
            for ( final String reviewWord : review.split ( " " ) ) { //this loop runs for every word in the current iterating sentence
                //adding single occurance of every word int a set if it is contained in keywords arraylist
                if ( ! encounteredWords.contains ( reviewWord ) && keywordList.contains ( reviewWord ) ) {
                    Integer currentFrequency = frequencies.getOrDefault ( reviewWord, 0 );
                    //getOrDefault returns mapped value for key ,if not found then returns default value
                    frequencies.put ( reviewWord, currentFrequency + 1 );
                    encounteredWords.add ( reviewWord );
                }
            }
        }

        String[] frequencyArray = frequencies.keySet ().toArray ( new String[k] );
        Arrays.sort ( frequencyArray, ( a, b ) -> frequencies.get ( a ).equals ( frequencies.get ( b ) )
                ? a.compareTo ( b )
                : frequencies.get ( b ) - frequencies.get ( a ) );

        return Arrays.copyOfRange ( frequencyArray, 0, k );
    }

    public static void main ( String[] args ) {
        int k = 2;
        String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular." };
        String[] result = getMostFrequentCommonwords ( reviews, keywords, k );
        for ( int i = 0; i < result.length; i++ ) {
            System.out.print ( result[i] + " " );
        }
    }
}
