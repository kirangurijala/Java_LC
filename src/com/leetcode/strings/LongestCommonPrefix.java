package com.leetcode.strings;
/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

[fo,foo,fooo,f124]

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

*/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];
        for (String str : strs) {
            while (!str.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.print(longestCommonPrefix(strs));
    }
}