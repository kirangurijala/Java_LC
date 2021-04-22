package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-perfect-square/
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.



Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false


Constraints:

1 <= num <= 2^31 - 1
 */
public class ReverseOnlyLetters {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        long l=0, m=0, r=num/2;
        while(l<=r){
            m=(l+r)/2;
            if(m*m==num){
                return true;
            }
            if(m*m>num){
                r=m-1;
            }else{
                l=m+1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ReverseOnlyLetters solution = new ReverseOnlyLetters();
   //     System.out.println(solution.removeDuplicates("abbaca"));
    }
}