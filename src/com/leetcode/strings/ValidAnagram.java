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
        if(s == null || t == null || s.length()!=t.length()){
            return false;
        }

        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }

        for(char ch:t.toCharArray()){
            count[ch-'a']--;
        }

        for(int n:count){
            if(n!=0){
                return false;
            }
        }

        return true;}
}