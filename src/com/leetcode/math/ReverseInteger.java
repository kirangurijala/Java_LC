package com.leetcode.math;

/*
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.



Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

Example 4:

Input: x = 0
Output: 0

*/
public class ReverseInteger {
    public static int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            if (rev > Integer.MAX_VALUE || rev > Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }

        return (int) rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}