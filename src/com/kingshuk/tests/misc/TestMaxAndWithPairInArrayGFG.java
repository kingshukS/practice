package com.kingshuk.tests.misc;

public class TestMaxAndWithPairInArrayGFG {
    // Utility function to check number of elements
// having set msb as of pattern
    static int checkBit(int pattern, int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }

    // Function for finding maximum and value pair
    static int maxAND (int arr[], int n)
    {
        int res = 0, count;

        // iterate over total of 30bits
        // from msb to lsb
        for (int bit = 31; bit >= 0; bit--)
        {
            // find the count of element
            // having set msb
            count = checkBit(res | (1 << bit), arr, n);

            // if count >= 2 set particular
            // bit in result
            if ( count >= 2 )
                res |= (1 << bit);
        }

        return res;
    }

    // driver function
    public static void main(String argc[])
    {
        int arr[] = {16,15,22};
        int n = arr.length;
        System.out.println("Maximum AND Value = " +
                maxAND(arr, n));
    }
}
