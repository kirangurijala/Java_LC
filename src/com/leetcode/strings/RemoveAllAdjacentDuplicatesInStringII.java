package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

*/
public class RemoveAllAdjacentDuplicatesInStringII {
  //Time complexity: O(n^2/k), where nn is a string length. We scan the string no more than n/k times.
  //Space complexity: O(1). A copy of a string may be created in some languages, however, the algorithm itself only uses the current string.
  public String removeDuplicates(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    int length = -1;
    while (length != sb.length()) {
      length = sb.length();
      for (int i = 0, count = 1; i < sb.length(); ++i) {
        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
          count = 1;
        } else if (++count == k) {
          sb.delete(i - k + 1, i + 1);
          break;
        }
      }
    }
    return sb.toString();
  }
  //Time complexity: O(n),  where nn is a string length. We process each character in the string once.
  //Space complexity: O(n). to store the count for each character.
  public String removeDuplicatesMemoise(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    int count[] = new int[sb.length()];
    for (int i = 0; i < sb.length(); ++i) {
      if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
        count[i] = 1;
        continue;
      }

      count[i] = count[i - 1] + 1;
      if (count[i] == k) {
        sb.delete(i - k + 1, i + 1);
        i = i - k;
      }
    }
    return sb.toString();
  }
  //Time complexity: O(n),  where nn is a string length. We process each character in the string once.
  //Space complexity: O(n). to store the count for each character.
  public String removeDuplicatesstack(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    Stack<Integer> counts = new Stack<>();
    for (int i = 0; i < sb.length(); ++i) {
      if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
        counts.push(1);
        continue;
      }

      int incremented = counts.pop() + 1;
      if (incremented == k) {
        sb.delete(i - k + 1, i + 1);
        i = i - k;
      } else {
        counts.push(incremented);
      }
    }
    return sb.toString();
  }

    public static void main(String[] args) {
      RemoveAllAdjacentDuplicatesInStringII solution= new RemoveAllAdjacentDuplicatesInStringII();
		System.out.println(solution.removeDuplicates("abbaca",3));
  	}
}