package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/largest-unique-number/
Given an array of integers A, return the largest integer that only occurs once.

If no integer occurs once, return -1.



Example 1:

Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation:
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
Example 2:

Input: [9,9,8,8]
Output: -1
Explanation:
There is no number that occurs only once.


Note:

1 <= A.length <= 2000
0 <= A[i] <= 1000
 */
public class LargestUniqueNumber {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public int largestUniqueNumber(int[] A) {
        Map<Integer,Integer> counts=new HashMap<>();
        for (int n:A) {
            counts.put(n,counts.getOrDefault(n,0)+1);
        }

        int max=-1;
        for (int n:counts.keySet()) {
            if(counts.get(n)==1){
                max=Math.max(max,n);
            }
        }

        return max;
    }


    //Time complexity: O(n)
    //Space complexity: O(1000)
    public int largestUniqueNumberByArray(int[] A) {
        int[] counts=new int[1001];
        for (int n:A) {
            counts[n]++;
        }

        int max=-1;
        for (int i = counts.length-1; i >= 0; i--) {
            if(counts[i]==1){
                max=Math.max(max,i);
            }
        }

        return max;
    }


    //Time complexity: O(nlogn)
    //Space complexity: O(1)
    public int largestUniqueNumberBySort(int[] A) {
        // Sort in ascending order.
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            // If there is no duplicate return.
            if (i == 0 || A[i] != A[i - 1]) return A[i];

            // While duplicates exist.
            while (i > 0 && A[i] == A[i - 1]) {
                i--;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LargestUniqueNumber solution = new LargestUniqueNumber();
        int[] arr={5,7,3,9,4,9,8,3,1};
        System.out.println(solution.largestUniqueNumber(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}