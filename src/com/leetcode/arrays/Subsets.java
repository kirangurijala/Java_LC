package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/

Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.


Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
*/
public class Subsets {
    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int arr[] = {1, 2, 3};
        System.out.println(solution.subsets(arr));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(n);
                res.add(temp);
            }
        }

        return res;
    }
}