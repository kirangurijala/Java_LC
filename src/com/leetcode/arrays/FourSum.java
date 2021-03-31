/*
Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.

Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).

Explain and code the most efficient solution possible, and analyze its time and space complexities.

Example:

input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20

output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                     # whose sum is 20. Notice that there
                     # are two other quadruplets whose sum is 20:
                     # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                     # asked to return the just one quadruplet (in an
                     # ascending order)*/
package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/4sum/description/

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [], target = 0
Output: []


Constraints:

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;
        if (n == 4) if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n - 4; i++) {
            for (int j = i + 1; j < n - 3; j++) {
                int r = target - (nums[i] + nums[j]);
                int low = j + 1, high = n - 1;
                while (low < high) {
                    if (nums[low] + nums[high] < r)
                        low++;
                    else if (nums[low] + nums[high] > r)
                        high--;
                    else
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSum sol=new FourSum();
        for (List<Integer> list : sol.fourSum(new int[]{1, 2, 6, 8, 3, 10,}, 16))
            System.out.println(list);
    }
}
