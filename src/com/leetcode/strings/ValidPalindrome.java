package com.leetcode.strings;
  /*
  https://leetcode.com/problems/valid-palindrom

  125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

    */

public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        if (s == null || s.trim().length() <= 1) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
    }
}


