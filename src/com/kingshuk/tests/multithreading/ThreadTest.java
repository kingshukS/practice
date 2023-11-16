package com.kingshuk.tests.multithreading;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadTest {
    private static final HashMap<String,List<Integer>> objects = new HashMap<>();
    private static int i;
    static {
        objects.put("t1", new ArrayList<Integer>());
        objects.put("t2",  new ArrayList<Integer>());
    }
    public static void main(String[] args) {
        System.out.println("value of i is :"+i);

        new Thread(t1).start();
        new Thread(t2).start();
    }
    private static void process(String name) {
        i++;
        List<Integer> list = objects.get(name);
        //Start business logic
        list.add(i);  // Could be some 100 lines of business logic is here
        //End business logic code
        System.out
                .println("Current Counter is: " + i + ", updated by: " + name);
        objects.put(name, list);
    }

    private static final Runnable t1 = new Runnable() {
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    process("t1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(objects);
        }
    };
    private static final Runnable t2 = new Runnable() {
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    process("t2");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(objects);
        }
    };

}