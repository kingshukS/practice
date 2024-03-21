package com.kingshuk.tests.misc;

public class TestRepeatingElementStarting0 {
    public static void main ( String[] args ) {
        int[] arr = { 1, 0, 2, 2, 2 };
        int element = findRepeatingElement ( arr, arr.length );
        System.out.println ( "Repeating element: " + element );
    }

    private static int findRepeatingElement ( int[] arr, int length ) {
        int slow = arr[0] + 1;
        int fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);
        slow = arr[0] + 1;
        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }
}
