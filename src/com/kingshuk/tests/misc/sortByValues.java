package com.kingshuk.tests.misc;

import java.util.*;

public class sortByValues {

    public static void main(String[] args)
    {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<String,Integer> hm1 = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry: list)
        {
            hm1.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }
}
