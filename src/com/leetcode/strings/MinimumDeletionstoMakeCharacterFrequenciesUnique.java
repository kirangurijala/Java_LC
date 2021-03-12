package com.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).



Constraints:

    1 <= s.length <= 105
    s contains only lowercase English letters.
*/
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch:s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)  + 1);


        Set<Integer> used = new HashSet<>();
        int res = 0;
        for (char c : map.keySet()) {
            int freq = map.get(c);
            while (used.contains(freq)) {
                freq--;
                res++;
            }
            if (freq != 0) {
                used.add(freq);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(minDeletions("ceabaacb"));
    }
}