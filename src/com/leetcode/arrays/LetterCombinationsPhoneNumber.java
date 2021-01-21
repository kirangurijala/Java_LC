package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsPhoneNumber solution = new LetterCombinationsPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.trim().length() == 0) {
            return result;
        }

        String[] mappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (char ch : digits.toCharArray()) {
            result = combine(mappings[ch - '0'], result);
        }

        return result;
    }

    private List<String> combine(String letters, List<String> list) {
        List<String> result = new ArrayList<>();
        for (char ch : letters.toCharArray()) {
            for (String s : list) {
                result.add(s + ch);
            }
        }
        return result;
    }
}