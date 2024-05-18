package com.kingshuk.tests.striver.patterns;

import java.util.Scanner;

public class Pattern21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == n-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printPattern2(int n) {
        // first row
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        // middle rows
        for (int i = 0; i < n - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < n - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        // last row
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
