package com.leetcode.strings;

/*
https://leetcode.com/problems/valid-anagram/
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int n : chars) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}