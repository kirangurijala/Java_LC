package com.leetcode.arrays;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if it is possible. Otherwise, return False.



Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true
Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.


Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 109
 */
public class DivideArrayinSetsofKConsecutiveNumbers {
    //nums = [1,2,3,3,4,4,5,6], k = 4
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> counts=new TreeMap<>();/////TREEEEEEEEEEEEEEEEEE MAP
        for (int n:nums) {
            counts.put(n,counts.getOrDefault(n,0)+1);
        }

        //[1 1  2 1  3 2  4 2  51  6 1] k=4
        for (int key:counts.keySet()){
            Integer count = counts.get(key);
            if(count <=0){
                continue;
            }

            for(int i=0;i<k;i++){
                if(counts.getOrDefault(i+key,0)< count){
                    return false;
                }

                counts.put(i+key,counts.get(i+key)- count);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DivideArrayinSetsofKConsecutiveNumbers solution = new DivideArrayinSetsofKConsecutiveNumbers();
        System.out.println(solution.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6},4));
    }
}