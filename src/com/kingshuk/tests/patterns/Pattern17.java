package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            char ch = 'A';
            for (int j = 0; j < (2 * i) + 1; j++) {
                System.out.print(ch + " ");
                if (j < i) {
                    ch++;
                } else {
                    ch--;
                }
            }
            System.out.println();
        }
    }
}
