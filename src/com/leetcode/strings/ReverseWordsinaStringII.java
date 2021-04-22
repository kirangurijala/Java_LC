package com.leetcode.strings;
/*
https://leetcode.com/problems/reverse-words-in-a-string-ii/

Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 

    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces.
    The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?
*/

import java.util.ArrayDeque;
import java.util.Deque;

class ReverseWordsinaStringII {
    public static void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseWords22(char[] s) {
//        StringBuilder sb=new StringBuilder();
//        Deque<String> q=new ArrayDeque();
//        for(char ch:s){
//            if(ch!=' '){
//                sb.append(ch);
//            }else{
//                q.offerFirst(sb.toString());
//                sb.delete(0,sb.length());
//            }
//        }
//
//
//        q.offerFirst(sb.toString());
//        int index=0;
//        for(String str:q){
//            for(char ch:str.toCharArray()){
//                s[index++]=ch;
//            }
//
//            if(index<s.length)
//                s[index++]=' ';
//        }


        int l = 0, r = s.length - 1;
        while (l <= r && s[l] == ' ') ++l;
        while (l <= r && s[r] == ' ') --r;

        Deque<String> words = new ArrayDeque();
        StringBuffer word = new StringBuffer();
        while (l <= r) {
            char ch = s[l];
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() != 0) {
                words.offerFirst(word.toString());
                word.setLength(0);
            }
            l++;
        }

        words.offerFirst(word.toString());
        String result = String.join(" ", words);
        //         for(String str:dq){
//           for(char ch:str.toCharArray()){
//             s[index++]=ch;
//           }

//           if(index<s.length)
//             s[index++]=' ';
//         }
        int count = 0;
        for (char ch : result.toCharArray()) {
            s[count++] = ch;
        }
    }

    public static void main(String[] args) {
        reverseWords("  hello world!  ".toCharArray());
    }
}