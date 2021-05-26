package com.kingshuk.tests;

import java.util.ArrayList;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        TestQuadraticEquation testQuadraticEquation = new TestQuadraticEquation();
        ArrayList<Integer> list = testQuadraticEquation.quadraticRoots(280,399,573);
    }

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int f = (b * b) - (4 * a * c);
        if (f < 0) {
            list.add(-1);
            return list;
        }
        int x = (int) Math.floor((-b + Math.sqrt(f)) / (2 * a));
        int y = (int) Math.floor((-b - Math.sqrt(f)) / (2 * a));
        list.add(x);
        list.add(y);
        return list;
    }
}
