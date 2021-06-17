package com.kingshuk.tests;

public class TestFindTripletSum {
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 15;
        int arr_size = A.length;

        boolean bool = findTripletSum(A, arr_size, sum);
        System.out.println("Triplet sum present:"+(bool?"yes":"no"));
    }

    private static boolean findTripletSum(int[] a, int arr_size, int sum) {
        quickSort(a, 0,arr_size-1);
        for(int i=0; i<arr_size; i++){
            if(isPair(a,i+1,arr_size-1,sum-a[i]))
                return true;
        }
        return false;
    }

    public static void quickSort(int[] a, int lb, int ub) {
        if(lb<ub){
            int pi = partition(a,lb,ub);
            quickSort(a,lb,pi-1);
            quickSort(a,pi+1,ub);
        }
    }

    private static int partition(int[] a, int lb, int ub) {
        int pivot = a[lb];
        int start = lb;
        int end = ub;
        while(start<end){
            while(start<ub && a[start]<=pivot)
                start++;
            while(end>lb && a[end]>pivot)
                end--;
            if(start<end)
            {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }
        int temp = a[end];
        a[end] = a[lb];
        a[lb] = temp;
        return end;
    }

    private static boolean isPair(int[] a, int starting_index, int ending_index, int sum) {
        int low = starting_index;
        int high = ending_index;
        while(low<high){
            if(a[low]+a[high]==sum){
                return true;
            }else if(a[low]+a[high]>sum){
                high--;
            }else{
                low++;
            }
        }
        return false;
    }
}
