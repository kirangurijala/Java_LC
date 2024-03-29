package com.leetcode.bfs;

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
        Set<String> set=new HashSet<>(wordDict);
        boolean[] visited=new boolean[s.length()+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int start=q.poll();
            if(start==s.length()){
                return true;
            }

            if(visited[start]){
                continue;
            }

            visited[start]=true;
            for (int i = start; i <=s.length() ; i++) {
                if(wordDict.contains(s.substring(start,i))){
                    q.add(i);
                }
            }
        }

        return false;
    }

    public boolean wordBreak22(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length() + 1];
        visited[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (visited[j] && wordDictSet.contains(s.substring(j, i))) {
                    visited[i] = true;
                    break;
                }
            }
        }
        return visited[s.length()];
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