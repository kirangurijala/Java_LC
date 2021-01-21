package com.leetcode.strings;

/*
https://leetcode.com/problems/excel-sheet-column-title/

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"
*/
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        char[] chars=new char[26];
        for(char ch='A';ch<='Z';ch++){
            chars[ch-'A']=ch;
        }

        StringBuilder sb=new StringBuilder();
//        while(n!=0){
//          sb.append(chars[(n-1)%26]);
//          n=(n-1)/26;
//        }

        while(n!=0){
            n--;
            char temp=(char)('A'+(n%26));
            sb.append(temp);
            n=n/26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
      ExcelSheetColumnTitle solution= new ExcelSheetColumnTitle();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(28));
		System.out.println(solution.convertToTitle(701));
  	}
}