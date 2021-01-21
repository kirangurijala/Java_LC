package com.leetcode.arrays;

/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

453. Minimum Moves to Equal Array Elements
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/
public class MinimumMovesEqualArrayElements {
    public static int minMoves(int[] nums) {

        if (nums.length <= 1) return 0;
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }

        return moves;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(minMoves(arr));
    }
}