package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.



Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0


Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.

    */
public  class ConvertBinaryNumberinaLinkedListtoInteger {
  public int getDecimalValue(ListNode head) {
    int num = 0;
    while (head != null) {
      num = num * 2 + head.val;
      head = head.next;
    }
    return num;
  }
    public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls1);

   // System.out.println(reverseList(ls4));//4 3 2 1
    //System.out.println(ls4==reverseList(reverseList(ls4)));
  }
}