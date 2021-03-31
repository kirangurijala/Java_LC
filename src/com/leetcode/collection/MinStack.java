package com.leetcode.collection;

import java.util.Stack;

/*
https://leetcode.com/problems/min-stack/
155.
Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:
    Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
public class MinStack {

  /** initialize your data structure here. */
   Stack<Integer> stack;
   int min=Integer.MAX_VALUE;
  public MinStack() {
    stack=new Stack<>();
  }

  public  void push(int x) {
    if(x<=min){
      stack.push(min);
      min=x;
    }

    stack.push(x);
  }

  public  void pop() {
    if (stack.pop() == min) {
      min = stack.pop();
    }
  }

  public  int top() {
    return stack.peek();
  }

  public  int getMin() {
    return min;
  }

  public static void main(String[] args) {
    MinStack minStack=new MinStack();
    minStack.push(5);
    minStack.push(2);
    minStack.push(1);
    minStack.push(3);
    minStack.push(4);
    System.out.println(minStack.getMin());
    System.out.println(minStack.top());
    System.out.println( minStack.stack);
    minStack.pop();
    minStack.pop();
    minStack.pop();
    System.out.println(minStack.getMin());
    System.out.println(minStack.top());
    System.out.println( minStack.stack);

    System.out.println(minStack.getMin());
  }
}