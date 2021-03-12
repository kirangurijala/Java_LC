package com.leetcode.strings;

/*
https://leetcode.com/problems/longest-palindrome/

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome("abbaca"));
    }

    public int longestPalindrome(String s) {
        int[] chars=new int[128];
        for(char ch:s.toCharArray()){
            chars[ch-'A']++;
        }

        int max=0,extra=0;
        for(int n:chars){
            if(n%2==0){
                max=max+n;
            }else if(n/2>0){
                max=max+(n-1);
                extra=1;
            }else if(n==1){
                extra=1;
            }
        }
        return max+extra;
    }
}