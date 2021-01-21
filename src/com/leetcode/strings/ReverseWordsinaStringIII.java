package com.leetcode.strings;/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

import java.util.ArrayDeque;
import java.util.Deque;

class ReverseWordsinaStringIII {
    public String reverseWords2(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }

        result.append(word.reverse());
        return result.toString();
    }

    public String reverseWords(String s) {
        if(s==null || s.isBlank()){
            return s;
        }

        String[] words=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            // sb.append(new StringBuilder(word).reverse()).append(" ");
            sb.append(reverse(word)).append(" ");
        }

        return sb.toString().trim();
    }

    private String reverse(String s){
        int i=0,j=s.length()-1;
        char[] chars=s.toCharArray();
        while(i<j){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]= temp;
            i++;j--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseWordsinaStringIII solution = new ReverseWordsinaStringIII();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}