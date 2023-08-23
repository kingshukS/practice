package com.kingshuk.tests.misc;

public class TestSquareRootBinarySearch {
    public static void main(String[] args) {
        int x = 17;
        int ans = findSquareRoot(x);
        Math.sqrt(10);
        System.out.println("Square Root of x="+x+" is = "+ans);
    }

    private static int findSquareRoot(int x) {
        int low = 1;
        int high = x;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int msq = mid * mid;
            if(msq == x)
                return mid;
            else if(msq>x)
                high = mid -1;
            else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
