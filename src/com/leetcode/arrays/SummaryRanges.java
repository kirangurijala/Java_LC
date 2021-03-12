package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/summary-ranges/

You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        int[] arr={0,1,2,4,5,7};
        System.out.println(solution.summaryRanges(arr));
    }

            public List<String> summaryRanges(int[] nums) {
            List<String> list=new ArrayList<>();
            if(nums.length==1){
                list.add(nums[0]+"");
                return list;
            }

            for(int i=0;i<nums.length;i++){
                int n=nums[i];
                while(i+1<nums.length&&(nums[i+1]==1+nums[i])){
                    i++;
                }

                if(n!=nums[i]){
                    list.add(n+"->"+nums[i]);
                }else{
                    list.add(n+"");
                }
            }

            return list;
        }
    }
