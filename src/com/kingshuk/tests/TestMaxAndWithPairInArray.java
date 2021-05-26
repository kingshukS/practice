package com.kingshuk.tests;

public class TestMaxAndWithPairInArray {
    public static void main(String[] args) {
        int[] arr = {16,15,22};
        System.out.println(maxAND(arr,3));
    }
    public static int maxAND (int arr[], int n) {
        int res = 0;
        int maxValue = findMaxElement(arr,n);
        int log2 = findLog2ValueOfMaxElement(maxValue);
        while(log2>=0){
            int count = 0;
            for(int i = 0; i<n; i++){
                if(( (res|(1<<log2)) & arr[i]) == (res|(1<<log2))){
                    count++;
                }
            }
            if(count>=2){
                res |= (1 << log2);
            }
            log2--;
        }
        return res;
    }

    static int findMaxElement(int[] arr, int n){
        int max = 0;
        for(int i : arr){
            max = Math.max(max,i);
        }
        return max;
    }
    static int findLog2ValueOfMaxElement(int n){
        int x = 0;
        while((1 << x) <= n){
            x++;
        }
        return x-1;
    }
}
