package com.kingshuk.tests.stacks;

import java.util.Arrays;

import static com.kingshuk.tests.misc.TestNextGreaterElementToLeft.findNextGreaterElementToLeft;

public class NextGreaterElementToLeft {
    public static void main(String[] args) {
        int[] array = {15,10,18,12,4,6,2,8};
        int[] nextGreaterElementToLeft = findNextGreaterElementToLeft(array, array.length);
        Arrays.stream(nextGreaterElementToLeft).forEach(i -> System.out.print(i+" "));
    }
}
