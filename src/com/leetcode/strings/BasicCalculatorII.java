package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator-ii/

Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/
public class BasicCalculatorII {
    public static void main(String[] args) {
        BasicCalculatorII solution = new BasicCalculatorII();
        System.out.println(solution.calculate("3+2*2"));
    }

    int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        int length=s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }

            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == length - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int sum = 0;
        for (int n : stack) {
            sum = sum + n;
        }

        return sum;
    }
}