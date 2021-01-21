package com.leetcode.math;

/*
509. Fibonacci Number
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
*/
public class FibonacciNumber {
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int[] count = new int[N];
        count[0] = 0;
        count[1] = 1;
        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + count[i - 2];
        }
        return count[N];
    }

    public static void main(String[] args) {
        System.out.println(fib(123));
    }
}