package com.leetcode.strings;
  /*
  https://leetcode.com/problems/first-unique-character-in-a-string/

387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
   */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public  class FirstUniqueCharacterString {
      public static int firstUniqChar(String s) {
        if(s==null || s.length() == 0){
          return -1;
        }

        Map<Character,Integer> chars=new HashMap<>();
        for(char ch:s.toCharArray()){
          chars.put(ch,chars.getOrDefault(ch,0)+1);
        }

        for(char ch:s.toCharArray()){
          if(chars.get(ch)==1){
            return s.indexOf(ch);
          }
        }

        return -1;
      }


      public static void main(String[] args) {
       System.out.println(firstUniqChar("loveleetcode"));
      }
}