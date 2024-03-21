package com.kingshuk.tests.hundredDaysChallenge.day16;

public class FirstBadVersion {
    public int firstBadVersion ( int n, boolean[] isBadVersion ) {
        int s = 1;
        int e = n;
        int ans = 0;

        while (s <= e) {
            int mid = s + ( e - s ) / 2;
            if ( isBadVersion[mid] ) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}