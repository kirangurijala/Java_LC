package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val= Math.abs(nums[i]) - 1;
            if(nums[val]>0){
                nums[val] = -nums[val];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }

        return res;
    }

//   public List<Integer> findDisappearedNumbers(int[] nums) {
//       Set<Integer> set=new HashSet<>();
//       for(int n:nums){
//         set.add(n);
//       }

//       List<Integer> result=new ArrayList<>();
//       for(int i=1;i<=nums.length;i++){
//         if(!set.contains(i)){
//           result.add(i);
//         }
//       }

    //       return result;
//     }
    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray solution = new FindAllNumbersDisappearedinanArray();
        int[] arr={1,2,3};

       // System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}