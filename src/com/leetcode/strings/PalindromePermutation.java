package com.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/palindrome-permutation/

Given a string s, return true if a permutation of the string could form a palindrome.



Example 1:

Input: s = "code"
Output: false
Example 2:

Input: s = "aab"
Output: true
Example 3:

Input: s = "carerac"
Output: true


Constraints:

1 <= s.length <= 5000
s consists of only lowercase English letters.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s){
        int[] counts=new int[26];
        for(char c:s.toCharArray()){
            counts[c-'a']++;
        }

        int res=0;
        for (int c:counts) {
            if(c%2==1){
                res++;
            }
        }

        return res>1;
    }

    public boolean canPermutePalindromeset(String s) {
        Set<Character> set = new HashSet<Character>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }

        return set.size()<=1;
    }

    public static void main(String[] args) {
        PalindromePermutation solution = new PalindromePermutation();
      //  System.out.println(solution.removeDuplicates("abbaca"));
    }
}