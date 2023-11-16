package com.kingshuk.tests.misc;

public class StringCheck {

    public static void main(String[] args)
    {
        String s1 = "abc";
        String s4 = "abc";
        String s2 = s1.intern(); // SCP object reference
        System.out.println(s1==s4);
        System.out.println(s1==s2); // false
        String s3 = "abc";
        System.out.println(s2==s3);
        System.out.println(s3 == s4);
    }
}


