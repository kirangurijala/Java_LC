package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Share
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                count=count+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] arr={1,2,3};
        System.out.println(solution.subarraySum(arr,3));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}