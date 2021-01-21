package com.leetcode.arrays;

import java.util.HashMap;

/*
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/
public class SubarraySumEqualsK {
// public class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         for (int start = 0; start < nums.length; start++) {
//             int sum=0;
//             for (int end = start; end < nums.length; end++) {
//                 sum+=nums[end];
//                 if (sum == k)
//                     count++;
//             }
//         }
//         return count;
//     }
// }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(subarraySum(arr, 3));
    }
}