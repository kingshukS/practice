package com.kingshuk.tests;

class GfG {

    // Function to check if all of the digits
// in a number and it's product with q  
// are unequal or not  
    static boolean checkIfUnequal(int n, int q)
    {
        // convert first number into string
        String s1 = Integer.toString(n);
        int a[] = new int[26];

        // Insert elements from 1st number
        // to hash
        for (int i = 0; i < s1.length(); i++)
            a[s1.charAt(i) - '0']++;

        // Calculate corresponding product
        int prod = n * q;

        // Convert the product to string
        String s2 = Integer.toString(prod);

        // Using the hash check if any digit of
        // product matches with the digits of
        // input number
        for (int i = 0; i < s2.length(); i++)
            if (a[s2.charAt(i) - '0'] >= 1) // if yes, return false
                return false;

        // else, return true
        return true;
    }

    // Function to count numbers in the range [l, r]
// such that all of the digits of the number and  
// it's product with q are unequal  
    static int countInRange(int l, int r, int q)
    {
        int count = 0;

        for (int i = l; i <= r; i++) {
            // check for every number between l and r
            if (checkIfUnequal(i, q))
                count++;
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {

        int l = 10, r = 12, q = 2;

        System.out.println(countInRange(l, r, q));
    }
}  