package com.leetcode.strings;
/*
https://leetcode.com/problems/add-strings/

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"


Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
* */
public class AddStrings {
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

            sb.append(sum % 10);
            sum = sum / 10;
        }

        if (sum != 0) {
            sb.append(sum);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("123", "345"));
    }
}