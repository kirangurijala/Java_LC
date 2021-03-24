package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis(3));
    }

    List<String> res=new ArrayList<>();
    int max=0;
    public List<String> generateParenthesis(int n) {
        max=n;
        backTrack("",0,0);
        return res;
    }

    private void backTrack(String curr, int open, int close){
        if(curr.length()==max*2){
            res.add(curr);
            return;
        }

        if(open<max){
            backTrack(curr+"(",open+1,close);
        }
        if(open>close){
            backTrack(curr+")",open,close+1);
        }
    }
}