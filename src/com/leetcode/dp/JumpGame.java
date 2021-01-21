package com.leetcode.dp;

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println("i: " + i);
            if (i + nums[i] >= lastPos) {
                System.out.println(i + nums[i]);
                lastPos = i;
                System.out.println(" lastPos: " + lastPos);
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int arr[] = {9, 4, 2, 1, 0, 2, 0};
        System.out.println(canJump(arr));
    }
}