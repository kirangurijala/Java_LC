package com.leetcode.strings;/*
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

import java.util.*;

class ReverseWords {
    public static String reverseWords2(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);

        return String.join(" ", words);
    }

    public static String reverseWords(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') ++l;
        while (l <= r && s.charAt(r) == ' ') --r;

        Deque<String> words = new ArrayDeque();
        StringBuffer word = new StringBuffer();
        while (l <= r) {
            char ch = s.charAt(l);
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() != 0) {
                words.offerFirst(word.toString());
                word.setLength(0);
            }
            l++;
        }

        words.offerFirst(word.toString());
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.print(reverseWords("  hello world!  "));
    }
}