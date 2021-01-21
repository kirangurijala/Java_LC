package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
=-p[';

[4,3,2,7,8,2,3,1]



Output:
[2,3]
*/
public class FindAllDuplicates {
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0)
                res.add(index + 1);
            nums[index] = -nums[index];
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 2, 2, 1};
        System.out.println(findDuplicates(arr));
    }
}