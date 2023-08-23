package com.kingshuk.tests.multithreading;

import java.util.Map;

public class MapHelper3 implements Runnable{
    Map<String, Integer> map;

    public MapHelper3(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        map.put("Three", 3);
        map.put("Four", 14);
        map.put("Two",111);
        try {
            System.out.println("MapHelper3 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}