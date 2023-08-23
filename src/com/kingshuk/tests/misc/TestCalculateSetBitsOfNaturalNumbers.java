package com.kingshuk.tests.misc;

public class TestCalculateSetBitsOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(CountSetBits.countSetBits(4));
    }
}

class CountSetBits{

    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){

        // Your code here
        if(n == 0){
            return 0;
        }
        int x = find2raiseXLessThanN(n);
        int bitsBefore2raiseX = (1 << (x-1)) * x;
        int msbAfter2raiseX = n - (1 << x) + 1;
        int calculationLeft = n - (1 << x);

        return bitsBefore2raiseX + msbAfter2raiseX + countSetBits(calculationLeft);

    }
    public static int find2raiseXLessThanN(int n){
        int x = 0;
        while((1 << x) <= n){
            x++;
        }
        return x-1;
    }
}
