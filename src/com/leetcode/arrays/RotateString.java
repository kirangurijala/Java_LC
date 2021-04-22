package com.leetcode.arrays;

/*
https://leetcode.com/problems/rotate-string/

We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null) {
            //throw exception on A and B both being null?
            return false;
        }
        if(A.length() != B.length()) {
            return false;
        }
        if(A.length() == 0) {
            return true;
        }
        for(int i = 0; i < A.length(); i++) {
            if(rotateString(A, B, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean rotateString(String A, String B, int rotation) {
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt((i+rotation)%B.length())) {
                return false;
            }
        }
        return true;
    }
    public boolean rotateString22(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
    public static void main(String[] args) {
        RotateString solution = new RotateString();
        int[] arr={1,2,3};

     //   System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}