package com.leetcode.strings;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-words/

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively
*/
public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();
        System.out.println(solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> q=new PriorityQueue<>((a, b) -> (count.get(a)).equals(count.get(b)) ? b.compareTo(a) : count.get(a) - count.get(b));
        for (String word: count.keySet()) {
            q.add(word);
            if (q.size() > k) q.poll();
        }

        List<String> ans = new ArrayList();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        Collections.reverse(ans);
        return ans;
    }

    public List<String> topKFrequent22(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        System.out.println(count);
        List<String> topKFrequentWords = new ArrayList(count.keySet());
        Collections.sort(topKFrequentWords, (a, b) -> (count.get(a)).equals(count.get(b)) ? a.compareTo(b) : count.get(b) - count.get(a));

        System.out.println(topKFrequentWords);
        return topKFrequentWords.subList(0, k);
    }
}