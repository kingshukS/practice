package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= 2*i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
