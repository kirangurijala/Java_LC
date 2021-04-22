package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (String word : words){
            char[] table = new char[26];
            int temp = word.length();
            for (char c : word.toCharArray()){
                table[c - 'a']++;
            }
            for (int i = 0; i < 26; i++){
                if(map.getOrDefault((char)(i + 'a'),0) < table[i]){
                    temp = 0;
                    break;
                }
            }
            res += temp;
        }
        return res;
    }
    public int countCharacters22(String[] words, String chars) {
        int[] count=new int[26];
        for(char ch:chars.toCharArray()){
            count[ch-'a']++;
        }

        int result=0;
        for(String word:words){
            boolean res=true;
            int temp[]=count.clone();
            for(char ch:word.toCharArray()){
                temp[ch-'a']--;
                if(temp[ch-'a']<0){
                    res=false;
                    break;
                }


            }

            if(res)
                result=result+word.length();

        }

        return result;
    }
    public static void main(String[] args) {
        FindWordsThatCanBeFormedbyCharacters solution = new FindWordsThatCanBeFormedbyCharacters();
     //   System.out.println(solution.removeDuplicates("abbaca"));
    }
}