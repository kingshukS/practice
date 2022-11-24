package com.kingshuk.tests.hundredDaysChallenge.day12;

public class AddString {
    public static void main(String[] args) {
        System.out.println(new AddString().addStrings("123", "43"));
    }

    public String addStrings(String num1, String num2) {
        int carry = 0;
        String result = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i>=0 || j >=0 || carry!=0)
        {
            int x = i>=0 ? num1.charAt(i) - '0' : 0;
            int y = j>=0 ? num2.charAt(j) - '0' : 0;
            int sum = x+y+carry;
            carry = sum/10;
            result = sum%10+result;
            i--;
            j--;
        }
        return result;
    }
}
