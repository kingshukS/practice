package com.kingshuk.tests.binarySearch;

import java.util.Arrays;

import static com.kingshuk.tests.binarySearch.BinarySearchBounds.lowerBound;

public class FloorAndCeil {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 5)));
    }
    public static int[] getFloorAndCeil(int[] nums, int x) {
        return new int[] {findFloor(nums, x), findCeil(nums, x)};
    }

    public static int findFloor( int[] arr, int b ) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] <= b){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public static int findCeil( int[] arr, int b ) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] >= b){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
