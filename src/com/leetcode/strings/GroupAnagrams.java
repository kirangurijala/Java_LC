package com.leetcode.strings;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]



Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lower-case English letters.
*/
public class GroupAnagrams {
//  public List<List<String>> groupAnagrams(String[] strs) {
//    Map<String, List<String>> map = new HashMap<>();
//    for(String s: strs){
//      int[] arr = new int[26];
//      for(int i = 0;i<s.length();i++){
//        arr[s.charAt(i) - 'a']++;
//      }
//      String temp = Arrays.toString(arr);
//      List<String> ls = map.getOrDefault(temp, new ArrayList<String>());
//      ls.add(s);
//      map.put(temp,ls);
//    }
//    return new ArrayList<>(map.values());
//  }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs) {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String word=String.valueOf(chars);
            map.putIfAbsent(word,new ArrayList<>());
            map.get(word).add(str);
        }

        return new ArrayList<>(map.values());
    }
}