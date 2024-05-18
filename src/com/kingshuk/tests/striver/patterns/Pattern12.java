package com.kingshuk.tests.striver.patterns;

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            for (j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            for (j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
