package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/permutations-ii/
GGiven a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
]
 */
public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int arr[] = {1,2,3};
        System.out.println(solution.permuteUnique(arr));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}