package com.kingshuk.tests;

public class TestRepeatingElementStarting1 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,3,3};
        int element = findRepeatingElement(arr,arr.length);
        System.out.println("Repeating element: "+element);
    }

    private static int findRepeatingElement(int[] arr, int length) {
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);
        slow = arr[0];
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
