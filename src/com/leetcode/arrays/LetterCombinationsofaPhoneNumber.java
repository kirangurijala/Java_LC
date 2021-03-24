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
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        double d=11/3;
        System.out.println(d);
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        int arr[] = {1, 2, 3};
        System.out.println(solution.letterCombinations("456"));
//        for (int n:solution.twoSum(arr,9)) {
//            System.out.print(n+" ");
//        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits.length()==0){
            return res;
        }

        res.add("");
        for(char ch:digits.toCharArray()){
            res=combine(digitletter[ch-'0'],res);
        }

        return res;
    }

    private List<String> combine(String digitletter,List<String> l){
        List<String> res=new ArrayList<>();
        for(char ch:digitletter.toCharArray()){
            for(String x:l){
                res.add(x+ch);
            }
        }

        return res;
    }

    public List<String> letterCombinations22(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0){
            return res;
        }

        String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (char digit:digits.toCharArray()) {
            List<String> temp=new ArrayList<>();
            for (char ch:letters[digit-'0'].toCharArray()) {
                for(String x:res){
                    temp.add(x+ch);
                }
            }
            res=temp;
        }
        return res;
    }
}