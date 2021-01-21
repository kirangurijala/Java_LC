package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

    */
public  class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // Empty list
    if (head == null) {
      return null;
    }

    // Move the two pointers until they reach the proper starting point
    // in the list.
    ListNode cur = head, prev = null;
    while (m > 1) {
      prev = cur;
      cur = cur.next;
      m--;
      n--;
    }

    // The two pointers that will fix the final connections.
    ListNode con = prev, tail = cur;

    // Iteratively reverse the nodes until n becomes 0.
    ListNode third = null;
    while (n > 0) {
      third = cur.next;
      cur.next = prev;
      prev = cur;
      cur = third;
      n--;
    }

    // Adjust the final connections as explained in the algorithm
    if (con != null) {
      con.next = prev;
    } else {
      head = prev;
    }

    tail.next = cur;
    return head;
  }

  public ListNode reverseBetween22(ListNode head, int m, int n) {
    ListNode fakeHead = new ListNode(-1);
    fakeHead.next = head;
    ListNode prev = fakeHead;
    ListNode curr = fakeHead.next;
    int i = 1;
    while (i < m) {
      prev = curr;
      curr = curr.next;
      i++;
    }
    ListNode node = prev;
    while (i <= n) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
      i++;
    }
    node.next.next = curr;
    node.next = prev;
    return fakeHead.next;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    ReverseLinkedListII rsl=new ReverseLinkedListII();
    System.out.println(rsl.reverseBetween(ls4,2,4));
     }
}