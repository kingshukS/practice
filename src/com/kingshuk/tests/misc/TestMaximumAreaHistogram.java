package com.kingshuk.tests.misc;

import java.util.Stack;

public class TestMaximumAreaHistogram {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println(findMaximumAreaHistogram(arr, arr.length));
    }

    public static int findMaximumAreaHistogram(int[] arr, int n) {
        int[] NSLi = getNextSmallerToLeft(arr, n);
        int[] NSRi = getNextSmallerToRight(arr, n);
        return calculateMaximumArea(arr, NSLi, NSRi, n);
    }

    private static int calculateMaximumArea(int[] arr, int[] NSLi, int[] NSRi, int n) {
        int maxArea = 0;
        for(int i = 0; i<n; i++){
            int area = (NSRi[i]-NSLi[i]-1)*arr[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static int[] getNextSmallerToRight(int[] arr, int n) {
        int[] NSRi = new int[n];
        Stack<Element> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && s.peek().value()>=arr[i]){
                s.pop();
            }
            if(s.isEmpty())
                NSRi[i] = n;
            else{
                NSRi[i] = s.peek().index();
            }
            s.push(new Element(arr[i],i));
        }
        //System.out.println(Arrays.toString(NSRi));
        return NSRi;
    }

    private static int [] getNextSmallerToLeft(int[] arr, int n) {
        int[] NSLi = new int[n];
        Stack<Element> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && s.peek().value()>=arr[i]){
                s.pop();
            }
            if(s.isEmpty())
                NSLi[i] = -1;
            else{
                NSLi[i] = s.peek().index();
            }
            s.push(new Element(arr[i],i));
        }
        //System.out.println(Arrays.toString(NSLi));
        return NSLi;
    }
}

class Element {
    private final int value;
    private final int index;

    Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int value() {
        return value;
    }

    public int index() {
        return index;
    }
}
