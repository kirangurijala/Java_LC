package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int n:nums) {
            set.add(n);
        }

        int max=0;
        for (int n:nums) {
            if(!set.contains(n-1)){
                int curr=n;
                int count=1;
                while(set.contains(curr+1)) {
                    count++;
                    curr++;
                }
                max=Math.max(max,count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] arr={100,4,200,1,3,2};
        System.out.println(solution.longestConsecutive(arr));
    }

    public int bruteForceLongestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int max = 0,  curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                curr++;
                continue;
            }

            max = Math.max(max, curr);
            curr = 1;
        }

        return Math.max(max, curr);
    }
}