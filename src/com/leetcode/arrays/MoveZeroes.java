package com.leetcode.arrays;

/*
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int index = 0; //[0 1 0 3 12]  // [1 3 12 ]
        for (int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(arr);
    }
}