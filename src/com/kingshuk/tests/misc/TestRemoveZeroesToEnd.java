package com.kingshuk.tests.misc;

public class TestRemoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = {10,20,0,20,0,0,1};
        int n = removeZeros(arr);
        for(int i=0; i<n; i++){
            System.out.print( arr[i]+" ");
        }
    }

    private static int removeZeros(int[] arr) {
      int k = 0;
      int i = 0;
      int n = arr.length;
      while(i<n){
          if(arr[i]!=0){
              arr[k] = arr[i];
              k++;
          }
          i++;
      }
      return k;
    }
}
