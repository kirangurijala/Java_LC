package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/permutations/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
]
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int arr[] = {1,2,3};
        System.out.println(solution.permute(arr));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // Arrays.sort(nums); // not necessary
        backtrack(new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int n:nums) {
            if (tempList.contains(n)) continue; // element already exists, skip
            tempList.add(n);
            backtrack(tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}