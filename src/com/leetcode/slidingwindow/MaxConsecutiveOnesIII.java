package com.leetcode.slidingwindow;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        int[] arr={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(solution.longestOnes(arr,3));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));

    }

    public int longestOnes(int[] A, int K) {
        int max=0,start=0,end=0,zeroCount=0;
        for (int n:A) {
            if(n==0){
                zeroCount++;
            }
            while(zeroCount>K){
                if(A[start]==0)  zeroCount--;
                start++;
            }
            end++;
            max=Math.max(max,end-start+1);
        }

        return max;
    }
}