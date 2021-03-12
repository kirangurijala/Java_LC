package com.leetcode.arrays;

/*
https://leetcode.com/problems/majority-element/

169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0, major = 0;
        for (int n : nums) {
            if(count==0){
                count++;
                major=n;
            }else if(major==n){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 1, 1, 1, 1, 4, 2};
        System.out.println(majorityElement(arr));
    }
}