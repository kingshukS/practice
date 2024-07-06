package com.kingshuk.tests.striver.arrays;

class SubArrayProduct {
	public static void main(String[] args) {
		System.out.println(new SubArrayProduct().maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
	}
    public int maxProduct(int[] arr) {
        long result = arr[0];
	    for(int i=0;i<arr.length;i++) {
	        long p = arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	            result = Math.max(result,p);
	            p *= arr[j];
	        }
	        result = Math.max(result,p);
	    }
	   return (int)result;   
    }
}