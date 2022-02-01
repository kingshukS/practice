package com.kingshuk.tests.Multithrreading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMaptest {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(new ConcurrentHashMap<>());
        Runnable1 r1 = new Runnable1(resource);
        Runnable2 r2 = new Runnable2(resource);

        Thread T1 = new Thread(r1);
        Thread T2 = new Thread(r2);

        T1.start();
        T2.start();

//        T1.join();
//        T2.join();

//        resource.printMap();
    }
}

class Resource {
    Map<Integer, String> map;

    public Resource(Map<Integer, String> map) {
        this.map = map;
    }

    void putData(Integer key, String value) {
        System.out.println("......Putting element.....");
        this.map.put(key, value);
    }

    String getData(Integer key) {
        return this.map.get(key);
    }

    void printMap() throws InterruptedException {
        System.out.println("........Started Printing........");
        Iterator<Integer> itr = this.map.keySet().iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            Thread.sleep(200);
            System.out.println("Key:" + i + " Value:" + this.map.get(i));
        }
    }
}

class Runnable1 implements Runnable {

    Resource resource;

    public Runnable1(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Started:" + Thread.currentThread().getName());
        int i = 0;
        while(true) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.resource.putData(i, "Ponu : " + i);
            i++;
        }
    }
}


class Runnable2 implements Runnable {

    Resource resource;

    public Runnable2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Started:" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                resource.printMap();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}