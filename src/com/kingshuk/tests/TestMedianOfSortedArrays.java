package com.kingshuk.tests;

public class TestMedianOfSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {5,6,7,8,9};
        int[] a2 = {30,40,50,50};

        double median = findMedianOfArrays(a1,a2);
        System.out.println("Median is = "+median);
    }
    //Time Complexity=BigO(log(min(n1,n2)))
    private static double findMedianOfArrays(int[] a1, int[] a2) {
        int[] x = null;
        int[] y = null;
        if(a1.length <= a2.length){
            x = a1;
            y = a2;
        }else{
            x = a2;
            y = a1;
        }
        int low = 0;
        int high = x.length -1;
        int n1 = x.length;
        int n2 = y.length;
        while(low<=high){
            int partitionX = (low+high)/2;
            int partitionY = (n1+n2+1)/2-partitionX;

            int maxLeftX = partitionX>0?x[partitionX-1]:Integer.MIN_VALUE;
            int maxLeftY = partitionY>0?y[partitionY-1]:Integer.MIN_VALUE;
            int minRightX = partitionX<n1?x[partitionX]:Integer.MAX_VALUE;
            int minRightY = partitionY<n2?y[partitionY]:Integer.MAX_VALUE;

            if(maxLeftX<=minRightY && maxLeftY<=minRightX)
            {
                if((n1+n2)%2 ==0){
                    return (double)(Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }else{
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX>minRightY){
                high = partitionX -1;
            }else{
                low = partitionX +1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted");
    }
}
