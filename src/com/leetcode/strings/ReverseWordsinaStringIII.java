package com.leetcode.strings;/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class ReverseWordsinaStringIII {
    public String reverseWords2(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (char ch:input.toCharArray()) {
            if (ch != ' ') {
                word.append(ch);
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
        StringBuilder sb=new StringBuilder();
        List<String> ls=new ArrayList<>();
        for (char ch:s.toCharArray()) {
            if(!Character.isWhitespace(ch)){
                sb.append(ch);
                continue;
            }
            // if(sb.length()!=0&&Character.isWhitespace(ch)){ if there more than one spase
            ls.add(reverse(sb.toString()));
            sb.setLength(0);
            //}
        }

        ls.add(reverse(sb.toString()));
        return String.join(" ",ls);
    }


    public String reverseWords3(String s) {
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