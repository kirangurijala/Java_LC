package com.leetcode.arrays;

/*
https://leetcode.com/problems/maximum-product-of-three-numbers/

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6


Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int m1=Integer.MAX_VALUE, m2=Integer.MAX_VALUE;
        int M1=Integer.MIN_VALUE, M2=Integer.MIN_VALUE, M3=Integer.MIN_VALUE;
        for(int n:nums){
            if(n<=m1){
                m2=m1;
                m1=n;
            } else if(n<=m2){
                m2=n;
            }

            if(n>=M1){
                M3=M2;
                M2=M1;
                M1=n;
            } else if(n>=M2){
                M3=M2;
                M2=n;
            } else if(n>=M3){
                M3=n;
            }
        }

        return Math.max(m1*m2*M1, M1*M2*M3);
        //Arrays.sort(nums);
        // return Math.max(nums[0]*nums[1]*nums[nums.length-1],
        //         nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
    public static void main(String[] args) {
        MaximumProductofThreeNumbers solution = new MaximumProductofThreeNumbers();
        int[] arr={1,2,3};

   //     System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}