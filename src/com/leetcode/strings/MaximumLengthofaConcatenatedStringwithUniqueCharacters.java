package com.leetcode.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26


Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    //method 1:
    private int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }

    public void dfs(List<String> arr, int index, String concatenatStr) {
        if (isUnique(concatenatStr)) {
            max = Math.max(max, concatenatStr.length());
        }

        if (index == arr.size() || !isUnique(concatenatStr)){
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, concatenatStr + arr.get(i));
        }
    }

    public boolean isUnique(String s) {
        int[] counts = new int[26];
        for (char ch:s.toCharArray()) {
            counts[ch-'a']++;
        }

        for (int count:counts) {
            if(count>1){
                return false;
            }
        }

        return true;
    }
//method 2
    public int maxLength2(List<String> arr) {
        return process(arr, "", 0);
    }

    int process(List<String> arr, String soFar, int index) {
        if (index > arr.size()) return 0;
        Set<Character> set = new HashSet<>();
        for(char c: soFar.toCharArray()) {
            if(set.contains(c)) return 0;
            set.add(c);
        }

        int max = soFar.length();
        for(int i = index; i < arr.size(); i++) {
            max = Math.max(max, process(arr, soFar + arr.get(i), i + 1));
        }
        return max;
    }

    private List<String> arr;
    private int idx;


    //Method 3by DFS
    private int result = 0;

    public int maxLengthDFS(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        dfs(arr, "", 0);

        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumLengthofaConcatenatedStringwithUniqueCharacters solution = new MaximumLengthofaConcatenatedStringwithUniqueCharacters();
        //System.out.println(solution.removeDuplicates("abbaca"));
    }
}