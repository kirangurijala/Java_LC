package com.leetcode.arrays;

/*
https://leetcode.com/problems/house-robber/
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

*/
public class HouseRobber {
    public static int rob(int[] nums) {
        int p1 = 0, p2 = 0, temp = 0;
        for (int n : nums) {
            temp = p1;
            p1 = Math.max(p1, n + p2);
            p2 = temp;
        }

        return p1;
    }


    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 1, 1, 1, 1, 4, 2};
        System.out.println(rob(arr));
    }
}