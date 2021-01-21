package com.leetcode.strings;
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
    public static String solution(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(solution("CABABD"));
    }
}