package com.kingshuk.tests.hundredDaysChallenge.day16;

class KthLargest {
    private final int k;
    private final int[] minHeap;

    public KthLargest ( int k, int[] nums ) {
        this.k = k;
        if ( nums.length >= k ) {
            minHeap = nums;
        } else {
            minHeap = new int[k];
            System.arraycopy ( nums, 0, minHeap, 0, nums.length );
            for ( int i = nums.length; i < k; i++ ) {
                minHeap[i] = Integer.MIN_VALUE;
            }
        }
        buildMinHeap ( minHeap );
        for ( int i = 0; i < minHeap.length - k; i++ ) {
            deleteRoot ( minHeap, minHeap.length - i );
        }
    }

    public static void main ( String[] args ) {
        KthLargest kth = new KthLargest ( 3, new int[]{ 2, 1, 3, 4 } );
        System.out.println ( kth.add ( 3 ) );
    }

    public int add ( int val ) {
        if ( val > minHeap[0] ) {
            minHeap[0] = val;
            minHeapify ( minHeap, k, 0 );
        }
        return minHeap[0];
    }

    private void buildMinHeap ( int[] nums ) {
        for ( int i = nums.length / 2; i >= 0; i-- ) {
            minHeapify ( nums, nums.length, i );
        }
    }

    private void deleteRoot ( int[] nums, int n ) {
        nums[0] = nums[n - 1];
        minHeapify ( nums, n - 1, 0 );
    }

    private void minHeapify ( int[] nums, int n, int i ) {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if ( l < n && nums[l] < nums[min] ) {
            min = l;
        }
        if ( r < n && nums[r] < nums[min] ) {
            min = r;
        }
        if ( min != i ) {
            int swap = nums[i];
            nums[i] = nums[min];
            nums[min] = swap;
            minHeapify ( nums, n, min );
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */