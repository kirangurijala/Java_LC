package com.leetcode.arrays.topK;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-elements/

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
*/
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

     PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->counts.get(b)-counts.get(a));
     for(Integer num:counts.keySet()){
       q.add(num);
     }

     int[] topK=new int[k];
     for (int i = 0; i < k; i++) {
       topK[i]=q.poll();
     }

//        List<Integer> res = new ArrayList<>(counts.keySet());
//        Collections.sort(res, (a, b) -> counts.get(b) - counts.get(a));
//        int[] topK = new int[k];
//        for (int i = 0; i < k; i++) {
//            topK[i] = res.get(i);
//        }

        return topK;
    }
}