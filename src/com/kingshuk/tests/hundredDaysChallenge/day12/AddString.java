package com.kingshuk.tests.hundredDaysChallenge.day12;

public class AddString {
    public static void main(String[] args) {
        System.out.println(new AddString().addStrings("123", "43"));
    }

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        while(i>=0 || j >=0)
        {
            int sum = carry;
            sum += i>=0 ? num1.charAt(i--) - '0' : 0;
            sum += j>=0 ? num2.charAt(j--) - '0' : 0;
            carry = sum/10;
            res.append(sum%10);
        }
        if(carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }
}
