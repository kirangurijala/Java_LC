package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            stack.pop();
            if (stack.empty()) {
                stack.push(i);
            } else {
                max = Math.max(max, i - stack.peek());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}