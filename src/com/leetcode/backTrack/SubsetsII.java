package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets-ii/
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        int arr[] = {4, 4, 4,1,4};
        System.out.println(solution.subsetsWithDup(arr));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtack(0,new ArrayList<>(),res,nums);
        return res;
    }

    private void backtack(int start,List<Integer> temp,List<List<Integer>> res,int[] nums){
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtack(i+1,temp,res,nums);
            temp.remove(temp.size()-1);
        }
    }
}