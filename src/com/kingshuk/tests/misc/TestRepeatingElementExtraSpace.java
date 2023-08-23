package com.kingshuk.tests.misc;

import java.util.Arrays;

public class TestRepeatingElementExtraSpace {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2,2};
        int element = findRepeatingElement(arr,arr.length);
        System.out.println("Repeating element: "+element);
    }

    private static int findRepeatingElement(int[] arr, int length) {
        boolean[] visited = new boolean[length];
        Arrays.fill(visited,false);
        for(int i=0; i<length; i++){
            if(visited[arr[i]]){
                return arr[i];
            }
            visited[arr[i]] = true;
        }
        return Integer.MAX_VALUE;
    }
}
