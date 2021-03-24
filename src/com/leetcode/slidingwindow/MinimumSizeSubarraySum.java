package com.leetcode.slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n))
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int[] arr={1,2,3};
        System.out.println(solution.minSubArrayLen(4, arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int start=0,min= Integer.MAX_VALUE,sum=0;
        for (int end = 0; end < nums.length ;end++) {
            sum=sum+nums[end];
            while (sum>=target){
                min = Math.min(min, end - start + 1);
                sum=sum-nums[start];
                start++;
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

}