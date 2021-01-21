package com.leetcode.strings;

/*
https://leetcode.com/problems/excel-sheet-column-number/

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701


*/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s==null || s.trim().isEmpty()){
            return 0;
        }
        int result=0;
        for(char ch:s.toCharArray()){
            result=result*26+(ch-'A'+1);
        }

        return result;
    }

    public static void main(String[] args) {
      ExcelSheetColumnNumber solution= new ExcelSheetColumnNumber();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
		System.out.println(solution.titleToNumber("ZY"));
  	}
}