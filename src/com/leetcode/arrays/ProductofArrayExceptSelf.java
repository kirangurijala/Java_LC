package com.leetcode.arrays;

/*
238. Product of Array Except Self
Share
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/
public class ProductofArrayExceptSelf {
// Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

// Numbers:     2    3    4     5
// Lefts:            2  2*3 2*3*4
// Rights:  3*4*5  4*5    5

// Let’s fill the empty with 1:

// Numbers:     2    3    4     5
// Lefts:       1    2  2*3 2*3*4
// Rights:  3*4*5  4*5    5     1

// We can calculate lefts and rights in 2 loops. The time complexity is O(n).

// We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {9, 4, 2, 1, 0, 2, 0};
        System.out.println(productExceptSelf(arr));
    }
}