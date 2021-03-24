package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int arr[] = {1,2,3,4};
        System.out.println(solution.combinationSum(arr,7));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
      //  Arrays.sort(candidates);
        backtrack(0,target,candidates,res,new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int remain,  int[] nums,List<List<Integer>> res, List<Integer> temp){
        if(remain<0){
            return;
        }
        if(remain == 0){
            res.add(new ArrayList(temp));
            return;
        }

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(i,remain-nums[i],nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}