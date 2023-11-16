package com.kingshuk.tests.misc;

import java.util.*;

public class MovieRating {
    private static final Map<String, List<Double>> movieMap = new HashMap<>();

    static void putRating(String movie, double rating) {
        List<Double> ratingList = movieMap.get(movie);
        if (ratingList == null) {
            ratingList = new ArrayList<>();
        }
        ratingList.add(rating);
        movieMap.put(movie, ratingList);
    }

   public double getAvgRating(String movie)
   {
       double rating = 0.00d;
       int count = 0;
       if(movieMap.containsKey(movie)) {
           for (Double d : movieMap.get(movie)) {
               rating = rating + d;
               count++;
           }
           double avg = rating/count;
           return avg;
       }
     return 0.0;
   }

    public int getRatingCount(String movie) {
        int count = 0;
        if(movieMap.containsKey(movie))
        {
            List<Double> ratingList = movieMap.get(movie);
            count = ratingList.size();
            return count;
        }
        return 0;
    }

    public static void main(String[] args){


        putRating("ABCD",2.1);
        putRating("Don",4.1);
        putRating("ABCD",1.1);
        putRating("ABCD",3.1);
        putRating("ABCD",2.2);
        putRating("Don",4.3);
        putRating("Don",4.5);

        Iterator<String> itr = movieMap.keySet().iterator();
        while(itr.hasNext()){
            System.out.println(movieMap.get(itr.next()));
        }
    }
    }