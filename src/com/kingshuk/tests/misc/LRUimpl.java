package com.kingshuk.tests.misc;

import java.util.*;

public class LRUimpl {

    static Set<Integer> set;
    int capacity;
    LRUimpl(int capacity)
    {
        set = new LinkedHashSet<>();
        this.capacity = capacity;
    }

    public void get(int key)
    {
        if(!set.contains(key))
        {
            put(key);
        }
        set.remove(key);
        set.add(key);
    }
    public void put(int key)
    {
        if(set.size()==capacity)
        {
            int first = set.iterator().next();
            set.remove(first);
        }
        set.add(key);
    }
    public static void main(String[] args)
    {
        LRUimpl ca = new LRUimpl(4);
        ca.get(1);
        ca.get(3);
        ca.get(4);
        ca.get(7);
        ca.get(3);
        ca.get(6);
        ca.get(7);

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext())
        {
            System.out.print(itr.next()+" ");
        }


    }
}
