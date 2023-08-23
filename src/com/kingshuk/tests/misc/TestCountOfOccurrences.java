package com.kingshuk.tests.misc;

public class TestCountOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,10,10,10,10,20,20,20,40};
        int searchKey = 41;
        int count = findCountOfOccurrences(arr, arr.length,searchKey);
        System.out.println("Count of : "+searchKey+" is: "+count);
    }

    private static int findCountOfOccurrences(int[] arr, int length, int searchKey) {
        TestIndexOfFirstOccurrence firstOccurrence = new TestIndexOfFirstOccurrence();
        TestIndexOfLastOccurrence lastOccurrence = new TestIndexOfLastOccurrence();
        int indexFirst = firstOccurrence.findFirstOccurrence(arr,length,searchKey);
        if(indexFirst==-1)
            return 0;
        int indexLast = lastOccurrence.findLastOccurrence(arr,length,searchKey);
        return indexLast-indexFirst+1;
    }
}
