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

  class MaxStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> maxStack=new Stack<Integer>();

    /** initialize your data structure here. */
    public MaxStack() {

    }

    int maxIndex=0;
    public void push(int x) {
      stack.push(x);
      if(maxStack.isEmpty()||x>=maxStack.peek()){
        maxStack.push(x);
        maxIndex = stack.size()-1;
      }else{
        maxStack.push(maxStack.peek());
      }


      //       int max = maxStack.isEmpty() ? x : maxStack.peek();
      //     maxStack.push(max > x ? max : x);

    }

    public int pop() {
//       int x=stack.pop();
//       if(x==maxStack.peek()){
//         maxStack.pop();
//         maxIndex--;
//       }

//       return x;
      maxStack.pop();
      return stack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int peekMax() {
      return maxStack.peek();
    }

    public int popMax() {
      int max = peekMax();
      Stack<Integer> temp = new Stack();
      while (top() != max) {
        temp.push(pop());
      }
      pop();
      while (!temp.isEmpty()) {
        push(temp.pop());
      }
      return max;
    }


  /**
   * Your MaxStack object will be instantiated and called as such:
   * MaxStack obj = new MaxStack();
   * obj.push(x);
   * int param_2 = obj.pop();
   * int param_3 = obj.top();
   * int param_4 = obj.peekMax();
   * int param_5 = obj.popMax();
   */

  public static void main(String[] args) {
    MaxStack minStack=new MaxStack();
    minStack.push(5);
    minStack.push(2);
    minStack.push(1);
    minStack.push(3);
    minStack.push(4);
    System.out.println(minStack.peekMax());
    System.out.println(minStack.top());
    System.out.println( minStack.stack);
    minStack.pop();
    minStack.pop();
    minStack.pop();
    System.out.println(minStack.peekMax());
    System.out.println(minStack.top());
    System.out.println( minStack.stack);

    System.out.println(minStack.peekMax());
  }
}