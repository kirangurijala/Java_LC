package com.leetcode.arrays;

import com.sun.source.tree.ReturnTree;

import java.util.*;

/*

 */
public class ZTest {
    public static void main(String[] args) {
        ZTest solution = new ZTest();
        List<Integer> list= Arrays.asList(4, 2, 3, 4, 5);
        PriorityQueue<Integer> q=new PriorityQueue<>((a, b)->a-b);
        for(int n:list){
            q.add(n);
//            if(q.size()>3){
//                q.poll();
//            }
        }
        System.out.println(q);

        Collections.sort(list,(a, b) -> a-b);
        Collections.sort(list,(a, b) -> b-a);
        System.out.println(list);
        int[] arr={1,2,3};
        System.out.println(solution.threeSum(arr));
    }

    public int threeSum(int[] nums) {

        return 0;
    }
    public String longestPalindrome(String s) {
        if(s==null || s.isBlank()){
            return s;
        }
        for (int i = 0; i <s.length() ; i++) {
            extendedPalindrome(s,i,i+1);
            extendedPalindrome(s,i,i);
        }

        return s.substring(start,start+max);
    }
    int start=0,max=0;
    private void extendedPalindrome(String s,int i, int j){
        while(i>0 && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
        }

        if(max<j-i+1){
            max=j-i+1;
            start=i;
        }
    }
}