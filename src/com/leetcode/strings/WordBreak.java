package com.leetcode.strings;

import java.util.*;

/*
https://leetcode.com/problems/word-break/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
    public boolean wordBreak222(String s, List<String> wordDict) {
        Queue<Integer> q=new LinkedList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        q.add(0);
        boolean[] visited = new boolean[s.length()];
        while (!q.isEmpty()){
            int start=q.poll();
            if(visited[start]){
                continue;
            }

            for (int i = start; i <=s.length() ; i++) {
                if(wordDict.contains(s.substring(start,i))){
                    q.offer(i);
                    if (i == s.length()) {
                        return true;
                    }
                }
            }
            visited[start]=true;
        }

        return false;
    }

    public boolean wordBreak22(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
     public boolean wordBreak(String s, List<String> wordDict) {
          return wordBreak(s, new HashSet<>(wordDict), 0);
      }
      private boolean wordBreak(String s, Set<String> wordDict, int start) {
          if (start == s.length()) {
              return true;
          }
          for (int end = start + 1; end <= s.length(); end++) {
              if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                  return true;
              }
          }
          return false;
      }
}