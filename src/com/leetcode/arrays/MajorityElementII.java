package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/majority-element-ii/
169. Majority Element
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

*/
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return result;
        int n1 = nums[0], n2 = nums[0], count1 = 0, count2 = 0;

        int count = 0, major = 0;
        for (int n : nums) {
            if (n1 == n) {
                count1++;
            } else if (n2 == n){
                count2++;
            }else if (count1 == 0) {
                n1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                n2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == n1)
                count1++;
            else if (n == n2)
                count2++;

        }

        if (count1 > nums.length / 3)
            result.add(n1);
        if (count2 > nums.length / 3)
            result.add(n2);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 1, 1, 1, 1, 4, 2};
        System.out.println(majorityElement(arr));
    }
}