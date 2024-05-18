package com.kingshuk.tests.striver.patterns;

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
