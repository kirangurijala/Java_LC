package com.leetcode.arrays;

/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/
public class TrappingRainWater {
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, result = 0;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[l]);
            if (leftMax < rightMax) {
                result += leftMax - height[l];
                l++;
            } else {
                result += rightMax - height[r];
                r++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}