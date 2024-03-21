package com.kingshuk.tests.JustPractice;

public class StringReverse {

    public static void main ( String[] args ) {
        String name = "SurajNehal";
        char[] nameChar = name.toCharArray ();
        char[] revName = new char[nameChar.length];
        int begin, i;
        for ( i = nameChar.length - 1, begin = 0; i >= 0; i--, begin++ ) {
            revName[begin] = nameChar[i];
            System.out.print ( revName[begin] );
        }
    }
}
