package com.leetcode.arrays.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/
public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray solution = new KthLargestElementinanArray();
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->a-b);
        for(int n:nums){
            q.add(n);
            if(q.size()>k){
                q.poll();
            }
            System.out.println(q);
        }

        return q.peek();
    }
}