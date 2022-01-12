package com.kingshuk.tests.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMergeIntervals {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(7,9));
        list.add(new Interval(6,10));
        list.add(new Interval(4,5));
        list.add(new Interval(1,3));
        list.add(new Interval(2,4));
        mergeAndPrint(list);
    }

    public static void mergeAndPrint(List<Interval> list) {
        Collections.sort(list); // Uses natural order of sorting, using start point(Comparable objects)
        while (list.size() > 1) {
            Interval i0 = list.get(0);
            Interval i1 = list.get(1);
            boolean isCoincident = i0.isCoIncident(i1);
            if(isCoincident)
            {
                Interval mergedInterval = i0.merge(i1);
                list.remove(i0);
                list.remove(i1);
                list.add(0,mergedInterval);
            }else{
                System.out.println(list.get(0));
                list.remove(0);
            }
        }
        if(list.size() == 1)
            System.out.println(list.get(0));
    }
}
