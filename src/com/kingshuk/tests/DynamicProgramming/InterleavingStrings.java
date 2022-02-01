package com.kingshuk.tests.DynamicProgramming;

public class InterleavingStrings {

    static boolean isInterleaved(String a,String b,String c,int n1,int n2,int n3)
    {
        boolean t[][] = new boolean[n1+1][n2+1];
        if(a.length()+b.length() != c.length())
            return false;

        return isInterleaved(a,b,c,n1+1,n2,n3+1)
                || isInterleaved(a,b,c,n1,n2+1,n3+1);
    }
    public static void main(String args[])
    {
        String a = "NHELA";
        String b = "GPUAT";
        String c = "GPUATNHELA";
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        System.out.println("Is string C interleaved : "+isInterleaved(a,b,c,n1,n2,n3));
    }
}
