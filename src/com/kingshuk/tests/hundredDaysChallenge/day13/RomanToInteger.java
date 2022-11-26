package com.kingshuk.tests.hundredDaysChallenge.day13;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
class RomanToInteger {
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        int number = 0, answer = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M': {
                    number = 1000;
                    break;
                }
                case 'D': {
                    number = 500;
                    break;
                }
                case 'C': {
                    number = 100;
                    break;
                }
                case 'L': {
                    number = 50;
                    break;
                }
                case 'X': {
                    number = 10;
                    break;
                }
                case 'V': {
                    number = 5;
                    break;
                }
                case 'I': {
                    number = 1;
                    break;
                }
            }
            if (number < prev)
                answer -= number;
            else
                answer += number;
            prev = number;
        }
        return answer;
    }
}