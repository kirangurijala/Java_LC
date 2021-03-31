package com.leetcode.strings;
  /*
  https://leetcode.com/problems/valid-palindrome-ii/

  680. Valid Palindrome II
  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

    */

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        if (s == null || s.trim().length() <= 1) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i +1, j) || isPalindrome(s, i, j- 1);
            }
        }

        return true;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("abcda"));
    }
}