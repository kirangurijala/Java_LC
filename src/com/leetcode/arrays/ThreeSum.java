package com.leetcode.arrays;

import java.util.*;

/*
https://leetcode.com/problems/3sum/

15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
*/
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int arr[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(arr));
    }

    //Time Complexity: {O}(n^2). twoSumII is O(n), and we call it n times.
    ////Sorting the array takes {O}(nlog{n}) so overall complexity is {O}(nlog{n} + n^2)O(nlogn+n2
    // ). This is asymptotically equivalent to \mathcal{O}(n^2)O(n
    //2
    // ).
    //
    //Space Complexity: from \mathcal{O}(\log{n})O(logn) to \mathcal{O}(n)O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(res);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}