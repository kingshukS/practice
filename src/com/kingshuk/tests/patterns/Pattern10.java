package com.kingshuk.tests.patterns;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide N: ");
        int n = scanner.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n-1; i>=1; i--)
        {
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }*/

        for(int i = 1; i<=(2*n - 1); i++)
        {
            int stars = i;
            if(i>n)
                stars = (2*n - i);
            for(int j = 1; j<=stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
