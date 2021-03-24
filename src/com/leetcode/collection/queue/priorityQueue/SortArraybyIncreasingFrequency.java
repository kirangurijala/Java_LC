package com.leetcode.collection.queue.priorityQueue;

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
public class SortArraybyIncreasingFrequency {
  public int[] frequencySort(int[] nums) {
    Map<Integer,Integer> counts=new HashMap<>();
    for (int n:nums) {
      counts.put(n,counts.getOrDefault(n,0)+1);
    }

    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->counts.get(a)!=counts.get(b)?counts.get(a)-counts.get(b):b-a);
    pq.addAll(counts.keySet());

    int[] ans = new int[nums.length];
    int index=0;
    while(!pq.isEmpty()){
      int key=pq.poll();
      int val=counts.get(key);
      for(int i=0;i<val;i++){
        ans[index++]=key;
      }
    }

    return ans;
  }

    public static void main(String[] args) {
      SortArraybyIncreasingFrequency solution= new SortArraybyIncreasingFrequency();
      System.out.println(solution.frequencySort(new int[]{1,1,2,2,2,3}));
      System.out.println(solution.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1}));
  	}
}