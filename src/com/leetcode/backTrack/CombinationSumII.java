package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/combination-sum-ii/
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

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
public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        int arr[] = {10,1,2,7,6,1,5};
        System.out.println(solution.combinationSum2(arr,8));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtrack(i+1,remain-nums[i],nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}