package com.leetcode.strings;

/*
https://leetcode.com/problems/add-binary/
67. Add Binary
 Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
    */

public class AddBinaryStrings {
    public static String addStrings(String a, String b) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }

            sb.append(sum % 2);
            sum = sum / 2;
        }

        if (sum != 0) {
            sb.append(sum);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("111", "101"));
    }
}