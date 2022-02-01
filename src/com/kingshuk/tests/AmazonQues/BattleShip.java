package com.kingshuk.tests.AmazonQues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BattleShip {
    public static String solution(int N, String S, String T) {
        int sink = 0;
        int hit = 0;
        Set<String> hitLocation = new HashSet<>(Arrays.asList(T.split(" ")));
        //hits contains all the hit cell locations
        String[] shipCells = S.split(",");
        for (String ship : shipCells) {
            Set<String> shipLocation = new HashSet<>();
            String[] splitTopAndBottom = ship.split(" ");
           
            // rows can be from 1 to 26 i.e it can be of two digits logic added to read both the digits
            int top = (splitTopAndBottom[0].charAt(1) > 57) //Ascii value of 57 -> 9
                    ? Integer.parseInt(splitTopAndBottom[0].charAt(0)+"")
                    : Integer.parseInt(splitTopAndBottom[0].charAt(0)+""+splitTopAndBottom[0].charAt(1)+"");

            int left = (top > 9 ) ? splitTopAndBottom[0].charAt(2) :  splitTopAndBottom[0].charAt(1);
            //if top comes out to be 2 digit then left will be at 2nd position else at 1st position.

            int bottom = (splitTopAndBottom[1].charAt(1) > 57)
                    ? Integer.parseInt(splitTopAndBottom[1].charAt(0)+"")
                    : Integer.parseInt(splitTopAndBottom[1].charAt(0)+""+splitTopAndBottom[1].charAt(1)+"");

            int right = (bottom > 9 ) ? splitTopAndBottom[1].charAt(2) :  splitTopAndBottom[1].charAt(1);
//same logic for bottom right location.
            for (int i = top; i <= bottom; i++) {

                for (int j = left; j <= right; j++) {
                    shipLocation.add("" + i + (char) j); //adding all cell  locations of individual ship in the hashset.
                  //  System.out.println("adding i :"+i+" adding j :"+(char) j);
                }
            }
            System.out.println("hits is :"+hitLocation);
            System.out.println("ship is :"+shipLocation);
            if (hitLocation.containsAll(shipLocation)) {

                //hits is a hashset which contains all the locations where hits hae been made
                //if hits contains all the values of current iterating ship's locations ,
                // that means the ship has sunk ,hence incrementing the sink counter
                sink++;
            } else {
                for (String com : shipLocation) {
            //   System.out.println("for ship comp :"+com +" hits.contains(com) :"+hitLocation.contains(com));
                    if (hitLocation.contains(com)) {
                        hit++;
                        break;
                    }
                }
            }

        }

        return "" + sink + "," + hit;

    }

    public static void main(String[] args) {
        // String ans = solution(4,"1B 2C,2D 4D","2B 2D 3D 4D 4A");
        String ans = solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
        System.out.println(ans);

    }
}
