package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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
}