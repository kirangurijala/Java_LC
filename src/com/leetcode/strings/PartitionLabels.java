package com.leetcode.strings;



import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/partition-labels/

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/
public class PartitionLabels {
    //Time Complexity: O(N), where N is the length of S.
    //Space Complexity: O(1) to keep data structure last of not more than 26 characters.
    public List<Integer> partitionLabels(String S) {
        int[] lastlocs=new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastlocs[S.charAt(i)-'a']=i;
        }

        int last=0,start=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < S.length() ; i++) {
            last=Math.max(last,lastlocs[S.charAt(i)-'a']);
            if(last==i){
                list.add(last-start+1);
                start=last+1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}