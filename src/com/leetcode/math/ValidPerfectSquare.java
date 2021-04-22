package com.leetcode.math;

/*
https://leetcode.com/problems/sqrtx/

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.



Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


Constraints:

0 <= x <= 231 - 1

 */
public class ValidPerfectSquare {

    public int mySqrt(int x) {
        if(x<2){
            return x;
        }

        int l=2,r=x/2,pivot=0;
        long temp=0;
        while(l<=r){
            pivot=(l+r)/2;
            temp=(long)pivot*pivot;
            if(temp<x){
                l=pivot+1;
            }else if(temp>x){
                r=pivot-1;
            }else{
                return pivot;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        ValidPerfectSquare solution = new ValidPerfectSquare();
        ///System.out.println(solution.sol(23));
        System.out.println(solution.mySqrt(24));
    }
}