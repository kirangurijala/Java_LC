package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/word-pattern/
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern("abba","dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap<>();
        char[] chars=pattern.toCharArray();
        String[] words=s.split(" ");
        if (words.length != pattern.length())
            return false;

        for(int i=0;i<words.length;i++){
            char ch=pattern.charAt(i);
            String word=words[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word))
                    return false;
            }

            if(map.containsValue(word)){
                if(map.get(ch)==null)
                    return false;
            }
            map.put(ch,word);
        }

        return true;
    }
}