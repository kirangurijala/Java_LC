package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"


Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.


Follow up: Could you find an algorithm that runs in O(n) time?
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> search=new HashMap<>();
        for (char c:t.toCharArray()) {
            search.put(c, search.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int l=0,r=0, formed=0, required=search.size();
        String res="";
        while(r<s.length()){
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if(search.containsKey(c)&& windowCounts.get(c).intValue() == search.get(c).intValue()){
                formed++;
            }

            while (l <= r && formed == required) {
                // Save the smallest window until now.
                if(res.isEmpty()||(r-l+1)<res.length()){
                    res=s.substring(l,r+1);
                }

                c = s.charAt(l);
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (search.containsKey(c) && windowCounts.get(c).intValue() < search.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        int[] arr={1,2,3};
       System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}