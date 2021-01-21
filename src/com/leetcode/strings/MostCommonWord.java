package com.leetcode.strings;
/*
819. Most Common Word
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0 || banned == null || banned.length == 0) {
            return "";
        }
        String[] words = paragraph.toLowerCase().split("\\W+");
        Map<String, Integer> count = new HashMap<>();
        List<String> bann = Arrays.asList(banned);
        int max = 0;
        String result = "";
        for (String word : words) {
            if (!bann.contains(words)) {
                int cnt = count.getOrDefault(word, 0) + 1;
                count.put(word, cnt);
                if (cnt > max) {
                    max = cnt;
                    result = word;
                }
            }
        }

        return result;
        //return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.print(mostCommonWord("strs", null));
    }
}