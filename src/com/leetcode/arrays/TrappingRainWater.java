package com.leetcode.arrays;

/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/
public class TrappingRainWater {
    /**
     *  Two Pointer approach
     *  left=0,right=height.length - 1 [40,20,50,10,0,5]
     *  loop through array (l<r)
     *      from left side find the leftmax, from right side find right max
     *      if leftmax<rightmax...
     *          max water we can store is leftmax-h[left](note: if the current value is leftmax we cannot store water, if it has prevleftmax we can store (prevmax-currval))
     *          increment l
     *       else
     *          max water we can store is rightmax-h[right](note: if the current value is leftmax we cannot store water, if it has prevleftmax we can store (prevmax-currval))
     *          decrement r
     * return result
     * Time complexity : O(n).
     *      We traverse the list containing n elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
     *
     * Space complexity : O(1).
     *      The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
     */
    public static int trap(int[] height) {
        int l=0,r=height.length-1,leftmax=0,rightmax=0,res=0;
        while(l<r){
            leftmax=Math.max(leftmax,height[l]);
            rightmax=Math.max(rightmax,height[r]);
            if(leftmax<rightmax){
                res=res+(leftmax-height[l]);// leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                l++;
            }else{
                res=res+(rightmax-height[r]);
                r--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}