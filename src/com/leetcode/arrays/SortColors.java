package com.leetcode.arrays;

/*
https://leetcode.com/problems/sort-colors/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
*/
public class SortColors {
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int arr[] = {2, 2, 1, 1, 0, 2, 0, 1, 1, 0};
        solution.sortColors(arr);
        System.out.println(arr);
    }

    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, p1, curr);
                curr++;
                p1++;
            } else if (nums[curr] == 2) {
                swap(nums, p2, curr);
                p2--;
            } else {
                curr++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}