package com.kingshuk.tests;

public class TestPythagoreanTriplet {
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 6, 5 };
        int arr_size = arr.length;
        if (isTriplet(arr, arr_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isTriplet(int[] arr, int arr_size) {
        TestFindTripletSum testFindTripletSum = new TestFindTripletSum();
        for(int i = 0; i<arr_size; i++){
            arr[i] = arr[i] * arr[i];
        }
        testFindTripletSum.quickSort(arr,0,arr_size-1);
        for(int i = arr_size-1; i>=2; i--){
            int c = arr[i];
            int low = 0;
            int high = i-1;
            while(low<high){
                if(arr[low]+arr[high] == c)
                    return true;
                else if(arr[low]+arr[high] > c){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return false;
    }


}
