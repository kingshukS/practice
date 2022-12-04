package com.kingshuk.tests.hundredDaysChallenge.day19;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> parentList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        parentList.add(list);
        if(numRows == 1)
            return parentList;
        List<Integer> previousList = new ArrayList<>(list);
        for(int i = 2; i<= numRows; i++){
            List<Integer> newRow= new ArrayList<>();
            newRow.add(1);
            for(int j = 1; j<previousList.size(); j++)
            {
                newRow.add(previousList.get(j)+previousList.get(j-1));
            }
            newRow.add(1);
            parentList.add(newRow);
            previousList = new ArrayList<>(newRow);
        }
        return parentList;
    }
}
