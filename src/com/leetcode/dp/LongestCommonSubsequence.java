package com.leetcode.dp;

/*
https://leetcode.com/problems/longest-common-subsequence/

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < text1.length(); ++i) {
            int prev = 0;
            for (int j = 0; j < text2.length(); ++j) {
                int curr = prev;
                prev = dp[j + 1];
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[j + 1] = curr + 1;
                }else{
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                }
                prev = dp[j + 1];
            }
        }
        return dp[n];
    }

    public int longestCommonSubsequence22(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=1+dp[i][j];
                }else{
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        int[] arr={1,2,3};
        System.out.println(solution.longestCommonSubsequence("actgattag","gtgtgatcg"));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));

    }

}