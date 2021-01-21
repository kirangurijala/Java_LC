package com.leetcode.math;

/*
https://leetcode.com/problems/single-number/
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
*/
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums = new int[]{4, 1, 2, 2, 3, 1, 4};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int n : nums) {
            a = a ^ n;
        }

        return a;
    }
}