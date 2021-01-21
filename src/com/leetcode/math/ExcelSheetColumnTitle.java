package com.leetcode.math;/*
168. Excel Sheet Column Title
Easy

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"
*/

class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        char[] chars = new char[26];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            chars[ch - 'A'] = ch;
        }

        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int mod = (n - 1) % 26;
            result.append(chars[mod]);
            n = (n - mod) / 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("com.leetcode.math.ExcelSheetColumnTitle: " + convertToTitle(701));
    }
}


