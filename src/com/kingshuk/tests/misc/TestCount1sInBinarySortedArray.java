package com.kingshuk.tests.misc;

public class TestCount1sInBinarySortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        int count = findCountOfOccurrencesOf1s(arr, arr.length);
        System.out.println("Count of 1s "+" are: "+count);
    }

    private static int findCountOfOccurrencesOf1s(int[] arr, int length) {
        TestIndexOfFirstOccurrence firstOccurrence = new TestIndexOfFirstOccurrence();
        int indexFirst = firstOccurrence.findFirstOccurrence(arr,length,1);
        if(indexFirst==-1)
            return 0;
        return length-indexFirst;
    }
}
