package com.leetcode.strings;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.



Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

*/
public class RemoveAllAdjacentDuplicatesInString {
  public String removeDuplicates(String S) {
    StringBuilder sb=new StringBuilder();
    for(char ch:S.toCharArray()){
      if(sb.length()==0 || sb.charAt(sb.length()-1)!=ch){
        sb.append(ch);
      }else{
        sb.deleteCharAt(sb.length()-1);
      }
    }

    return sb.toString();
  }

    public static void main(String[] args) {
      RemoveAllAdjacentDuplicatesInString solution= new RemoveAllAdjacentDuplicatesInString();
		System.out.println(solution.removeDuplicates("abbaca"));
  	}
}