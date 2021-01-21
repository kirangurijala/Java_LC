package com.leetcode.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/problems/implement-stack-using-queues/

Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).

Implement the MyStack class:

    void push(int x) Pushes element x to the top of the stack.
    int pop() Removes the element on the top of the stack and returns it.
    int top() Returns the element on the top of the stack.
    boolean empty() Returns true if the stack is empty, false otherwise.

Notes:

    You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.



Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False



Constraints:

    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.


Follow-up: Can you implement the stack such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
*/
public class ImplementStackusingQueues {
  static Queue<Integer> queue;
  static Queue<Integer> temp;
  /**
   * Initialize your data structure here.
   */
  public ImplementStackusingQueues() {
    queue = new LinkedList<>();
    temp = new LinkedList<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    while(!queue.isEmpty()){
      temp.add(queue.remove());
    }

    queue.add(x);
    while(!temp.isEmpty()){
      queue.add(temp.remove());
    }
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    return queue.remove();
  }

  /**
   * Get the front element.
   */
  public int top() {
    return queue.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return  queue.isEmpty();
  }


  public static void main(String[] args) {
    ImplementStackusingQueues implementQueueusingStacks=new ImplementStackusingQueues();
    implementQueueusingStacks.push(5);
    implementQueueusingStacks.push(2);
    implementQueueusingStacks.push(1);
    implementQueueusingStacks.push(3);
    implementQueueusingStacks.push(4);
    System.out.println(implementQueueusingStacks.top());
    System.out.println(implementQueueusingStacks.pop());
    System.out.println(queue);
    System.out.println(implementQueueusingStacks.pop());
    implementQueueusingStacks.push(4);
    System.out.println(queue);
  }
}