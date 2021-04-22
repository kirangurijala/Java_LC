package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int n=Math.max(nums1.length,nums2.length);
        int index =0;
        int[] res = new int[n];
        for(int num:nums2){
            if(map.get(num)!=null && map.get(num) >0){
                res[index++]=num;
                map.put(num,map.get(num)-1);

            }
        }


        return Arrays.copyOfRange(res, 0, index);
    }

    public int[] intersectSort(int[] nums1, int[] nums2) {
           Arrays.sort(nums1);
           Arrays.sort(nums2);
           int k=0;
           for (int i = 0, j = 0;i < nums1.length && j < nums2.length;) {
             if (nums1[i] < nums2[j]) {
                 i++;
             } else if (nums1[i] > nums2[j]) {
                 j++;
             } else {
                 nums1[k++] = nums1[i++];
                 j++;
             }
         }
         return Arrays.copyOfRange(nums1, 0, k);
    }
    public static void main(String[] args) {
        IntersectionofTwoArraysII solution = new IntersectionofTwoArraysII();
        int[] arr={1,2,3};

//        System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}