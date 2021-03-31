package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/
public class TwoSum {
/**
 *  Create a map place values and it's indices
 *  loop through the map
 *      Check the complement(target-curr) present in map and index not equal to complement index {[(3,2,4) -6], get(3)!=3)]
 *      return the current index and complement index
 *  Complexity Analysis:
 *
 * Time complexity : O(n).
 *      We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
 *
 * Space complexity : O(n).
 *      The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
 */
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        if (nums == null || size == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(nums[i], i);
        }


        for (int i = 0; i < size; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp) && map.get(comp) != i) {
                return new int[]{i, map.get(comp)};
            }
        }

        return new int[]{-1, -1};
    }

    /**
     *  Check all the elements add sum of two numbers
     *
     *  Complexity Analysis:
     *
     * Time complexity :O(n^2)
     *      For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time.
     * Space complexity : O(n).
     *      The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
     */
    public int[] bruteForceTwoSum(int[] nums, int target) {
         for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
             if(nums[i]+nums[j]==target){
               return new int[]{i,j};
             }
           }
         }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        TwoSum solution = new TwoSum();
        System.out.println(solution.twoSum(arr, 9));
    }
}