package com.kingshuk.tests;

public class Test {
    public static void main(String[] args) {
        int a = 5, b = 10;
        swap(a, b);
        System.out.print("Swapped values: a = " + a + ", b = " + b);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap method: a = " + a + ", b = " + b);
    }
}
