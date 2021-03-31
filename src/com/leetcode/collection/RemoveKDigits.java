package com.leetcode.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/remove-k-digits/

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //Remove the k digits from the tail.
        Deque<Character> dq=new ArrayDeque<>();
        for(char ch:num.toCharArray()){
            while(k>0 && !dq.isEmpty() && dq.peekLast()>ch){
                k--;
                dq.removeLast();
            }
            dq.addLast(ch);
        }

        //Remove the remaining digits from the tail.
        while(k>0){
            k--;
            dq.removeLast();
        }

        // Remove all zeros from the front of the DQ
        while(!dq.isEmpty() && dq.peekFirst()=='0'){
            dq.removeFirst();
        }

        if(dq.isEmpty()){
            return "0";
        }

        // Build the number from DQ
        StringBuilder sb=new StringBuilder();
        for(char ch:dq){
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        System.out.println(solution.removeKdigits("1432219",3));
    }
}