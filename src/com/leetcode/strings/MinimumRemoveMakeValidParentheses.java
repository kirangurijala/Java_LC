package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"*/
public class MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
      StringBuilder sb=new StringBuilder(s);
      Stack<Integer> indexToRemove=new Stack<>();
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '(') {
          indexToRemove.add(i);
          continue;
        }
        if (sb.charAt(i) == ')') {
          if (!indexToRemove.isEmpty()) {
            indexToRemove.pop();
          } else {
            sb.setCharAt(i, '*');
          }
        }
      }

      while(!indexToRemove.isEmpty()){
        sb.setCharAt(indexToRemove.pop(),'*');
      }

      return sb.toString().replaceAll("\\*","");
    }

    public static void main(String[] args) {
      MinimumRemoveMakeValidParentheses solution= new MinimumRemoveMakeValidParentheses();
		System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
  	}
}