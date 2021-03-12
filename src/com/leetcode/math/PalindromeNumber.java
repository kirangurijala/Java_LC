package com.leetcode.math;

/*
https://leetcode.com/problems/palindrome-number/

9. Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
*/
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0 || x%10==0 && x != 0){
            return false;
        }

        int rev=0;
        while(x>rev){
            rev = rev * 10 + x % 10;
            x=x/10;
        }

        return rev/10==x || rev==x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }
}