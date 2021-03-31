package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
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


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> symbols = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                symbols.push(')');
            } else if (ch == '{') {
                symbols.push('}');
            } else if (ch == '[') {
                symbols.push(']');
            } else if (symbols.isEmpty() || symbols.pop() != ch) {
                return false;
            }
        }
        return symbols.isEmpty();
    }


    public boolean isValidchararray(String s) {
        char[] stack = new char[s.length()];
        int head = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack[head++] = ')';
                    break;
                case '{':
                    stack[head++] = '}';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                default:
                    if (head == 0 || stack[--head] != c) return false;
                    break;
            }
        }

        return head ==0;
}
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()())"));
    }
}