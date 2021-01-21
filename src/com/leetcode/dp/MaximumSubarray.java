package com.leetcode.dp;

/*53. Maximum Subarray
Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [0]
Output: 0
Example 4:

Input: nums = [-1]
Output: -1
Example 5:

Input: nums = [-2147483647]
Output: -2147483647

*/
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

//2 4 3 1 2 2
//         int max=nums[0], sum=0, n=nums.length;
//         for(int i=0;i<nums.length;i++){
//             sum=nums[i];
//             if(nums[i]>max)
//                 max = nums[i];

//             for(int j=i+1;j<nums.length;j++){
//                 sum = sum + nums[j];
//                 if(sum>max)
//                 max = sum;
//           }
//       }

    //       return max;
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}