package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int up = i;
                int down = 2 * n - i - 2;
                int left = j;
                int right = 2 * n - j - 2;
                int min = Math.min(Math.min(left, right), Math.min(up, down));
                System.out.print(n - min);
            }
            System.out.println();
        }
    }
}
