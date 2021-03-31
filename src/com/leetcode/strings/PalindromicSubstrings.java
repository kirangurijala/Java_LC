package com.leetcode.strings;

import java.util.List;

/*
https://leetcode.com/problems/palindromic-substrings/

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.
*/
public class PalindromicSubstrings {
  int count=0;
  public int longestPalindrome(String S) {
    if(S==null || S.length()<1){
      return 0;
    }

    for (int i = 0; i <S.length() ; i++) {
      extendedPalindrome(S,i,i+1);
      extendedPalindrome(S,i,i);
    }

    return count;
  }

  private void  extendedPalindrome(String S, int j,int k){
    while (j>=0&&k<S.length() && S.charAt(j)==S.charAt(k)){
      j--;
      k++;
      count++;
    }
  }

  public static void main(String[] args) {
      PalindromicSubstrings solution= new PalindromicSubstrings();
		  System.out.println(solution.longestPalindrome("abbaca"));
  	}
}