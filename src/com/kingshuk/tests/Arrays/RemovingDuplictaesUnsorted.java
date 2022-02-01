package com.kingshuk.tests.Arrays;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemovingDuplictaesUnsorted {

    public LinkedHashSet<Integer> remDups(int arr[],int n)
    {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        for(int i =0;i<n;i++) {
            if (!lhs.contains(arr[i]))
            {
                lhs.add(arr[i]);
            }
        }
        return lhs;
    }
    public static void main(String args[])
    {
        RemovingDuplictaesUnsorted removingDuplictaesUnsorted = new RemovingDuplictaesUnsorted();
        int arr[] = {1,3,2,5,4,3,2,2,7,8,1,5};
        int n = arr.length;
        LinkedHashSet<Integer> linkedHashSet;
        linkedHashSet = removingDuplictaesUnsorted.remDups(arr,n);
        System.out.println(linkedHashSet);

        //For Java8 only
        Integer[] origArray = new Integer[] { 1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 8 };
        List<Integer> listWithoutDuplicates = Arrays.asList(origArray).stream().distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }
}
