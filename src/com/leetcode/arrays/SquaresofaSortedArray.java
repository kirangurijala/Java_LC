package com.leetcode.arrays;

import java.util.Arrays;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquaresofaSortedArray {
    public static void main(String[] args) {
        SquaresofaSortedArray solution = new SquaresofaSortedArray();
        int[] arr={-4,-1,0,3,9};
        Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));

        System.out.println(solution.sortedSquares(arr));
    }

    public int[] sortedSquares(int[] nums) {
        int i=0, j=nums.length-1;
        int[] res=new int[nums.length];
        for (int index= nums.length-1; index >=0 ; index--) {
            int a=nums[i]*nums[i];
            int b=nums[j]*nums[j];
            if(a>b){
                res[index]=a;
                i++;
            }else{
                res[index]=b;
                j--;
            }
        }

       return res;
    }
}