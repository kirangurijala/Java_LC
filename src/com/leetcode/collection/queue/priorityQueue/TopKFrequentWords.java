package com.leetcode.collection.queue.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
  public List<String> topKFrequent(String[] words, int k) {
    Map<String,Integer> counts=new HashMap<>();
    for(String word:words){
      counts.put(word,counts.getOrDefault(word,0)+1);
    }

    PriorityQueue<String> q=new PriorityQueue<>((a,b)->(counts.get(a)).equals(counts.get(b))?a.compareTo(b):counts.get(b)-counts.get(a));
    for(String word:counts.keySet()){
      q.add(word);
    }

    List<String> topKFrequentWords=new ArrayList();
    while(topKFrequentWords.size()<k){
      topKFrequentWords.add(q.poll());
    }

    return topKFrequentWords;
  }

    public static void main(String[] args) {
      TopKFrequentWords solution= new TopKFrequentWords();
      System.out.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
		  System.out.println(solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
  	}
}