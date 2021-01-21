package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/*
202. Happy Number
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example:

Input: 19
Output: true
Explanation:
1(2) + 9(2) = 82
8(2) + 2(2) = 68
6(2) + 8(2) = 100
1(2) + 0(2) + 0(2) = 1
*/
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = nextInt(n);
        }

        return true;
    }

    public static int nextInt(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum = sum + d * d;
            n = n / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}