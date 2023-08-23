package com.kingshuk.tests.misc;

public class MedianOfSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if(nums1.length < nums2.length)
        {
            A = nums1;
            B = nums2;
        }
        else{
            A = nums2;
            B = nums1;
        }
        int n1 = A.length;
        int n2 = B.length;

        int l = 0, r = n1;
        int half = (n1 + n2 + 1) / 2 ;
        while(l <= r)
        {
            int i = (l + r) / 2;
            int j = half- i;

            int Aright = (i == n1)?Integer.MAX_VALUE:A[i];
            int Aleft = (i == 0)?Integer.MIN_VALUE:A[i - 1];

            int Bright = (j == n2)?Integer.MAX_VALUE:B[j];
            int Bleft = (j == 0)?Integer.MIN_VALUE:B[j - 1];

            if(Aleft <= Bright && Bleft <= Aright)
            {
                if((n1 + n2) % 2 == 0)
                    return ((double)Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
                else
                    return Math.max(Aleft, Bleft);
            }
            else if(Aleft > Bright)
                r = i - 1;
            else
                l = i + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfSortedArray().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
