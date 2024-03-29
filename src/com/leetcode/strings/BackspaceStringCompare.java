package com.leetcode.strings;

import java.util.Stack;

/*
https://leetcode.com/problems/backspace-string-compare/
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a##c", t = "#a#c"
Output: true
Explanation: Both s and t become "c".
Example 4:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.


Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if(S == null ||T == null){
            return false;
        }

        return removeBackSpace(S).equals(removeBackSpace(T));
    }

    private String removeBackSpace(String str){
        Stack<Character> stack= new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch!='#'){
                stack.push(ch);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }




//      return removeBackspace(S).equals(removeBackspace(T));

//  private String removeBackspace(String str){
//       String res="";
//       int count=0;
//       for(int i=str.length()-1;i>=0;i--){
//         if(str.charAt(i)=='#'){
//           count++;
//         }else{
//           if(count>0){
//             count--;
//           }else{
//             res=res+str.charAt(i);
//           }
//         }
//       }
//       return res;
//     }


    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();
       // System.out.println(solution.removeDuplicates("abbaca"));
    }
}