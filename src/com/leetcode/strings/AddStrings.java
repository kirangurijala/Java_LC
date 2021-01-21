package com.leetcode.strings;

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