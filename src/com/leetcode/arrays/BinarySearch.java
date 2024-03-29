package com.leetcode.arrays;

/*
https://leetcode.com/problems/binary-search/
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1



Note:

    You may assume that all elements in nums are unique.
    n will be in the range [1, 10000].
    The value of each element in nums will be in the range [-9999, 9999].


 */
public class BinarySearch {
    public static void main(String[] args) {
       BinarySearch solution = new BinarySearch();
        int arr[] = {2, 3,4,5,6,7,8,9};
        System.out.println(solution.search(arr,6));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return -1;
        }

        int l=0,r=nums.length-1;
        int m=0;
        while(l<=r){
            m=l+(r-l)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }

        return -1;
    }
}