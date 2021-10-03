package com.kingshuk.tests.sorting;

import static com.kingshuk.tests.sorting.QuickSort.quickSort;

public class TestMeetingTheMaximumGuests {
    public static void main(String[] args) {
        int[] arr = {900, 600, 700};
        int[] dep = {1000, 800, 730};
        System.out.println("Maximum no of guest those can be met:"+findMaximumGuest(arr, dep));
    }

    private static int findMaximumGuest(int[] arr, int[] dep) {
        int res = 1;
        int i = 1;
        int j = 0;
        int max_guest = 1;
        int n = arr.length;
        quickSort(arr, 0, n-1);
        quickSort(dep, 0, n-1);
        while(i<n && j<n){
            if(arr[i]<=dep[j])
            {
                max_guest++;
                i++;
            }else{
                max_guest--;
                j++;
            }
            if(max_guest>res)
                res = max_guest;
        }
        return res;
    }
}
