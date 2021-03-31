package com.leetcode.math;

/*
https://leetcode.com/problems/sum-of-two-integers/
Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5


Constraints:

-1000 <= a, b <= 1000
 */
public class SumofTwoIntegers {
    int getSum(int a, int b) {
        if(b == 0){
            return a;
        }

        return getSum(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        SumofTwoIntegers solution = new SumofTwoIntegers();
        ///System.out.println(solution.sol(23));
        char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
      //  System.out.println(solution.exist(arr, "SEE"));
    }
}