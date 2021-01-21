package com.leetcode.arrays.topK;
/*
1481. Least Number of Unique Integers after K Removals
      Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.


    Example 1:
    Input: arr = [5,5,4], k = 1
    Output: 1
    Explanation: Remove the single 4, only 5 is left.
    Example 2:
    Input: arr = [4,3,1,1,3,3,2], k = 3
    Output: 2
    Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
*/

import java.util.*;

public class UniqueIntegersKRemovals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(count::get));
        pq.addAll(count.keySet());
        while (k > 0)
            k = k - count.get(pq.poll());
        return k < 0 ? pq.size() + 1 : pq.size();
    }

    public static int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : arr)
            count.put(n, 1 + count.getOrDefault(n, 0));
        List<Integer> values = new ArrayList<>(count.values());
        Collections.sort(values);
        int remove = 0;
        for (int n : values) {
            k = k - n;
            if (k < 0) {
                break;
            }
            remove++;
        }

        return count.keySet().size() - remove;
    }

    public static void main(String[] args) {
        System.out.print(findLeastNumOfUniqueInts(new int[]{3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2}, 3));
        System.out.print(findLeastNumOfUniqueInts2(new int[]{3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2}, 3));
    }
}
