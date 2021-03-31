package com.leetcode.arrays;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

33. Search in Rotated Sorted Array

You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
*/
// TS:O(log n) S:O(1)
public class SearchinRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        //1 take middle element check if it is target return target
        //check which side sorted
        //if left <=middle left sorted
        //if l<target<m target on left middle ,r=m-1
        //else target on right side l=m+1;
        //else right sorted
        //if m<target<r target on right middle, ,l=m+1
        //else target on left side r=m-1;

        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));
    }
}