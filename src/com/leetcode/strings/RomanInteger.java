package com.leetcode.strings;
  /*
  \https://leetcode.com/problems/roman-to-integer/
  13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.    */

public class RomanInteger {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'I') {
                sum = sum + 1;
            } else if (ch == 'V') {
                sum = sum + 5;
            } else if (ch == 'X') {
                sum = sum + 10;
            } else if (ch == 'L') {
                sum = sum + 50;
            } else if (ch == 'C') {
                sum = sum + 100;
            } else if (ch == 'D') {
                sum = sum + 500;
            } else if (ch == 'M') {
                sum = sum + 1000;
            }
        }

        if (s.contains("IV")) {
            sum = sum - 2;
        }
        if (s.contains("IX")) {
            sum = sum - 2;
        }
        if (s.contains("XL")) {
            sum = sum - 20;
        }
        if (s.contains("XC")) {
            sum = sum - 20;
        }
        if (s.contains("CD")) {
            sum = sum - 200;
        }
        if (s.contains("CM")) {
            sum = sum - 200;
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("IVVI"));
    }
}