package com.kingshuk.tests;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class OuterClass {
    
    private static String name = "OuterClass";
    private int i;
    protected int j;
    int k;
    public int l;

    //OuterClass constructor
    public OuterClass(int i, int j, int k, int l) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }

    public int getI() {
        return this.i;
    }

    //static nested class, can access OuterClass static variables/methods
    static class StaticNestedClass {
        private int a;
        protected int b;
        int c;
        public int d;

        public int getA() {
            return this.a;
        }

        public String getName() {
            return name;
        }
    }

    //inner class, non-static and can access all the variables/methods of the outer class
    class InnerClass {
        private int w;
        protected int x;
        int y;
        public int z;

        public int getW() {
            return this.w;
        }

        public void setValues() {
            this.w = i;
            this.x = j;
            this.y = k;
            this.z = l;
        }

        @Override
        public String toString() {
            return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z;
        }

        public String getName() {
            return name;
        }
    }

    //local inner class
    public void print(String initial) {
        //local inner class inside the method
        class Logger {
            String name;

            public Logger(String name) {
                this.name = name;
            }

            public void log(String str) {
                System.out.println(this.name + ": " + str);
            }
        }

        Logger logger = new Logger(initial);
        logger.log(name);
        logger.log("" + this.i);
        logger.log("" + this.j);
        logger.log("" + this.k);
        logger.log("" + this.l);
    }

    //anonymous inner class
    public String[] getFilesInDir(String dir, final String ext) {
        File file = new File(dir);
        //anonymous inner class implementing FilenameFilter interface
        String[] filesList = file.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }

        });
        return filesList;
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass(1,2,3,4);

        //static nested classes example
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        StaticNestedClass staticNestedClass1 = new StaticNestedClass();

        System.out.println(staticNestedClass.getName());
        staticNestedClass.d=10;
        System.out.println(staticNestedClass.d);
        System.out.println(staticNestedClass1.d);

        //inner class example
        InnerClass innerClass = outer.new InnerClass();
        System.out.println(innerClass.getName());
        System.out.println(innerClass);
        innerClass.setValues();
        System.out.println(innerClass);

        //calling method using local inner class
        outer.print("Outer");

        //calling method using anonymous inner class
        System.out.println(Arrays.toString(outer.getFilesInDir("src/com/journaldev/nested", ".java")));

        System.out.println(Arrays.toString(outer.getFilesInDir("bin/com/journaldev/nested", ".class")));
    }
}