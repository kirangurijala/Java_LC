package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/find-the-duplicate-number/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?


Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1


Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
*/
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber solution = new FindtheDuplicateNumber();
        int arr[] = {1, 2, 3, 2};
        System.out.println(solution.findDuplicate(arr));
    }
    public int findDuplicate2(int[] nums) {
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0)
                return index+1;
            nums[index] = -nums[index];
        }
        return 0;

    }
    public int findDuplicate3(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}