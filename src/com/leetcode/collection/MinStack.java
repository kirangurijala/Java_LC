package com.leetcode.collection;

import java.util.Stack;

/*
155. Min Stack
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
  static Stack<Integer> stack;
  static int min=Integer.MAX_VALUE;
  public MinStack() {
    stack=new Stack<>();
  }

  public static void push(int x) {
    if(x<=min){
      stack.push(min);
      min=x;
    }

    stack.push(x);
  }

  public static void pop() {
    if (stack.pop() == min) {
      min = stack.pop();
    }
  }

  public static int top() {
    return stack.peek();
  }

  public static int getMin() {
    return min;
  }

  public static void main(String[] args) {
    new MinStack();
    push(5);
    push(2);
    push(1);
    push(3);
    push(4);
    System.out.println(getMin());
    System.out.println(top());
    System.out.println(stack);
    pop();
    pop();
    pop();
    System.out.println(getMin());
    System.out.println(top());
    System.out.println(stack);

    System.out.println(getMin());
  }
}