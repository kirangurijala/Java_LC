package com.leetcode.strings;

import java.util.Arrays;
import java.util.Collections;

/*
https://leetcode.com/problems/maximum-number-of-balloons/

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:

Input: text = "nlaebolko"
Output: 1
Example 2:

Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.
 */
public class MaximumNumberofBalloons {
    //create int chars array  with aplabetic position 0,26 count indivual letters and fill the int array
// assgn count=0
//in infinite while loop
// check the vaue b(position 1) present in chars array , if valur present 0 break else decrease by 1
// check the vaue a(position 1) present in chars array , if valur present 0 break else decrease by 1
// check the vaue l(position 1) present in chars array , if valur present 0 break else decrease by 2
// check the vaue o(position 1) present in chars array , if valur present 0 break else decrease by 1
// check the vaue n(position 1) present in chars array , if valur present 0 break else decrease by 1
// increate counter
    public int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(char ch:text.toCharArray()){
            switch(ch){
                case 'b':
                    ++b;
                    break;
                case 'a':
                    ++a;
                    break;
                case 'l':
                    ++l;
                    break;
                case 'o':
                    ++o;
                    break;
                case 'n':
                    ++n;
                    break;
            }
        }

        return Collections.min(Arrays.asList(b,a,l/2,o/2,n));
    }
//     public int maxNumberOfBalloons(String text) {
//         int chars[]= new int[26];
//         for(int i=0;i<text.length();i++){
//             char ch= text.charAt(i);
//             chars[ch-'a'] = chars[ch-'a']+1;
//         }

//         int count=0;
//         while(true){
//             if(chars['b'-'a']==0) break;
//                 chars['b'-'a']=chars['b'-'a']-1;
//             if(chars['a'-'a']==0) break;
//                 chars['a'-'a']=chars['a'-'a']-1;
//             if(chars['l'-'a']==0) break;
//                 chars['l'-'a']=chars['l'-'a']-1;
//             if(chars['l'-'a']==0) break;
//                 chars['l'-'a']=chars['l'-'a']-1;
//             if(chars['o'-'a']==0) break;
//                 chars['o'-'a']=chars['o'-'a']-1;
//             if(chars['o'-'a']==0) break;
//                 chars['o'-'a']=chars['o'-'a']-1;
//             if(chars['n'-'a']==0) break;
//             chars['n'-'a']=chars['n'-'a']-1;
//             count++;
//         }

//     return count;
//     }


    public static void main(String[] args) {
        MaximumNumberofBalloons solution = new MaximumNumberofBalloons();
   //     System.out.println(solution.removeDuplicates("abbaca"));
    }
}