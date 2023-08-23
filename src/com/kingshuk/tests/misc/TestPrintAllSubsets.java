package com.kingshuk.tests.misc;

public class TestPrintAllSubsets {
    public static void main(String[] args) {
        String str = "ABCD";
        printAllSubsets(str,0,"");
    }

    private static void printAllSubsets(String str, int index, String curr) {
        if(index == str.length()){
            System.out.println("\""+curr+"\"");
            return;
        }
        printAllSubsets(str,index+1,curr);
        printAllSubsets(str,index+1,curr+str.charAt(index));
    }
}
