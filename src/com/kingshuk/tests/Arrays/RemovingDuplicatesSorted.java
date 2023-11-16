package com.kingshuk.tests.Arrays;

import java.util.Arrays;

public class RemovingDuplicatesSorted {

    public static int remDups(int[] arr, int n)
    {
        int j =0;

        for(int i=0;i<n-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n-1];
        return j;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;
        int j = remDups(arr,n);
        for (int i =0;i<j;i++)
        {
            System.out.println(arr[i]+" ");
        }

    }

    public static class Anagram {
        static int NO_OF_CHARS = 256;
        public static void main(String[] args)
        {
            char[] str1 = ("TRIANGLE").toCharArray();
            char[] str2 = ("INTEKRAL").toCharArray();
            if(isAnagram(str1,str2))
            {
                System.out.println("yes");
            }
            else
                System.out.println("no");
        }

        static boolean isAnagram(char[] str1, char[] str2)
        {
            int[] count1 = new int[NO_OF_CHARS];
            Arrays.fill(count1, 0);
            int i;

            // For each character in input strings, increment count in
            // the corresponding count array
            for (i = 0; i<str1.length && i<str2.length; i++) {
                count1[str1[i]]++;
                count1[str2[i]]--;
            }

            // If both strings are of different length. Removing this condition
            // will make the program fail for strings like "aaca" and "aca"
            if (str1.length != str2.length)
                return false;

            // See if there is any non-zero value in count array
            for (i = 0; i < NO_OF_CHARS; i++)
                if (count1[i]!=0)
                    return false;
            return true;
        }
    }

    public static class MatrixNumberSearch {

        public static void main(String[] args)
        {
            int[][] mat = { { 10, 20, 30, 40 },
                    { 15, 25, 35, 45 },
                    { 27, 29, 37, 48 },
                    { 32, 33, 39, 50 } };
            searchElement(mat,4,29);
        }
        static void searchElement(int[][] arr, int size, int num)
        {
            int i =0;
            int j =size-1;
            while(i<size && j>=0)
            {
                if(arr[i][j] == num)
                {
                    System.out.println("Number found at position "+ i+" "+j);
                    return;
                }

                if(arr[i][j] > num)
                {
                    j--;
                }
                else
                    i++;
            }
            System.out.print("n Element not found");
        }
    }
}
