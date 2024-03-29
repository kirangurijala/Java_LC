package com.leetcode.matrix;

import java.util.*;

/*
https://leetcode.com/problems/diagonal-traverse-ii/

Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

Example 1:



Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:



Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]
Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i].length <= 10^5
1 <= nums[i][j] <= 10^9
There at most 10^5 elements in nums.

*/
public class DiagonalTraverseII {
      public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int rows=nums.size();
        int n=0;
        for(int i=rows-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
                n++;
            }
        }


        int[] arr=new int[n];
        int index=0;
        for(int i=0;i<map.size();i++){
            for(int num:map.get(i)){
                arr[index++]=num;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        DiagonalTraverseII solution = new DiagonalTraverseII();
        int[][] arr = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};

       System.out.println(solution.findDiagonalOrder(null));
    }
}