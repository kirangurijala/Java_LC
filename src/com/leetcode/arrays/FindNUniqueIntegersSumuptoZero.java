package com.leetcode.arrays;

/*
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

Given an integer n, return any array containing n unique integers such that they add up to 0.


Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]


Constraints:

1 <= n <= 1000
 */
public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        for(int i=0;i<n/2;i++){
            nums [i]=i+1;
            nums [n-i-1]=-(i+1);
        }

        return nums;
    }
    public static void main(String[] args) {
        FindNUniqueIntegersSumuptoZero solution = new FindNUniqueIntegersSumuptoZero();
        int[] arr={1,2,3};

  //      System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}