package com.kingshuk.tests.striver.patterns;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            char c = 'A';
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }
}
