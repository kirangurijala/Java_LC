package com.leetcode.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/problems/moving-average-from-data-stream/

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
  public class MovingAverage {
  /** initialize your data structure here. */
   Queue<Integer> q;
   int size=0;
   int sum=0;
  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    this.size=size;
    q=new LinkedList<>();
  }

  public double next(int val) {
    if(q.size()==size){
      sum=sum-q.poll();
    }
    q.add(val);
    sum =sum+val;
    return (double) sum/q.size();
  }


  public static void main(String[] args) {
    MovingAverage mv= new MovingAverage(3);
    System.out.println( mv.next(2));
    System.out.println( mv.next(1));
    System.out.println( mv.next(5));
    System.out.println( mv.next(6));
    System.out.println( mv.next(4));
    System.out.println( mv.next(3));
  }
}