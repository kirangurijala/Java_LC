package com.leetcode.strings;

/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
*/
public class LongestPalindromicSubstring {
  int maxLen=0,lo=0;
  public String longestPalindrome(String S) {
    if(S==null || S.length()<1){
      return S;
    }

    if(S.length()%2==0){
      for (int i = 0; i <S.length() ; i++) {
        extendedPalindrome(S,i,i+1);
      }
    }else{
        for (int i = 0; i <S.length() ; i++) {
          extendedPalindrome(S,i,i);
        }
    }

    return S.substring(lo,lo+maxLen);
  }

  private void  extendedPalindrome(String S, int j,int k){
    while (j>=0&&k<S.length() && S.charAt(j)==S.charAt(k)){
      j--;
      k++;
    }

    if(maxLen<k-j-1){
      lo=j+1;
      maxLen=k-j-1;
    }
  }

  public static void main(String[] args) {
      LongestPalindromicSubstring solution= new LongestPalindromicSubstring();
		  System.out.println(solution.longestPalindrome("abbaca"));
  	}
}