package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.print((i + 1) + " ");
            }
            System.out.print(i + 1);
            System.out.println();
        }
    }
}
