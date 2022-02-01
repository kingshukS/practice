package com.kingshuk.tests.Multithrreading;

import java.util.Map;

public class MapHelper2 implements Runnable{
    Map<String, Integer> map;

    public MapHelper2(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        map.put("Two", 10);
        try {
            System.out.println("MapHelper2 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
