package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            int sp = i % 2;
            for (int j = 0; j < i - 1; j++) {
                System.out.print(sp + " ");
                sp = 1 - sp;
            }
            System.out.print(sp);
            System.out.println();
        }
    }
}
