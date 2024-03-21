package com.kingshuk.tests.Arrays;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Tricky {

    public static void main ( String[] args ) {

        byte[] array = new byte[7]; // length is bounded by 7
        new Random ().nextBytes ( array );
        String generatedString = new String ( array, StandardCharsets.UTF_8 );

        System.out.println ( generatedString );
    }
}
