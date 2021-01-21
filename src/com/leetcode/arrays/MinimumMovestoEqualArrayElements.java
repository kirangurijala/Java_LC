package com.leetcode.arrays;

import java.util.*;

/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

*/
public class MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElements solution = new MinimumMovestoEqualArrayElements();
        int arr[] = {1, 2, 3};
        System.out.println(solution.threeSum(arr));
    }

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