package com.leetcode.math;
  /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.



    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false

    Example 4:

    Input: s = "([)]"
    Output: false

    Example 5:

    Input: s = "{[]}"
    Output: true

    */

public class Solution {
    public static int minimumPlays(int N, int K) {
        if (K == 0) {
            return N - 1;
        }

        int count = 0;

        while (N > 1 && K > 0) {
            if (N % 2 == 0) {
                K--;
                N = N / 2;
                count++;
                continue;
            }
            N--;
            count++;
        }

        if (N > 1) {
            count = count + (N - 1);
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(minimumPlays(10, 10));
    }
}