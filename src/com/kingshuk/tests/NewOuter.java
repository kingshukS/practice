package com.kingshuk.tests;

public class NewOuter {
    static int b = 2;
    int a = 1;

    public static void main ( String[] args ) {
        NewOuter outer = new NewOuter ();
        NewOuter.InnerClass inner = outer.new InnerClass ();
        inner.run ();

    }

    public class InnerClass {
        static final int b = 4;
        int a = 3;

        public void run () {
            System.out.println ( "a = " + a );
            System.out.println ( "b = " + b );
            System.out.println ( "NewOuterTest.this.a = " + NewOuter.this.a );
            System.out.println ( "NewOuterTest.b = " + NewOuter.b );
            System.out.println ( "NewOuterTest.this.b = " + NewOuter.b );
        }
    }
}