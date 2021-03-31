package com.leetcode.bfs;

import java.util.*;

/*
https://leetcode.com/problems/word-break-ii/

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []


Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

 */
public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();

        Set<String> wordDictSet=new HashSet<>(wordDict);
        Queue<Integer> positions=new LinkedList<>();
        positions.add(0);
        Queue<String> formedStrings=new LinkedList<>();
        formedStrings.add("");
        while (!positions.isEmpty()){
            int size= positions.size();
            for (int i = 0; i < size; i++) {
                int start=positions.poll();
                String curr=formedStrings.poll();
                if(start==s.length()){
                    res.add(curr.trim());
                }

                for (int end = start+1; end <=s.length() ; end++) {
                    if(wordDictSet.contains(s.substring(start,end))){
                        positions.add(end);
                        formedStrings.add(curr+s.substring(start,end)+" ");
                    }
                }
            }
        }

        return res;
      }
}