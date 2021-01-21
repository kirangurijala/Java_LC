package com.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.



Constraints:

    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.



Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public  class LinkedListCycleII {
  private static ListNode getIntersect(ListNode head) {
    ListNode tortoise = head;
    ListNode hare = head;

    // A fast pointer will either loop around a cycle and meet the slow
    // pointer or reach the `null` at the end of a non-cyclic list.
    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;
      if (tortoise == hare) {
        return tortoise;
      }
    }

    return null;
  }

  public static ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    // If there is a cycle, the fast/slow pointers will intersect at some
    // node. Otherwise, there is no cycle, so we cannot find an entrance to
    // a cycle.
    ListNode intersect = getIntersect(head);
    if (intersect == null) {
      return null;
    }

    // To find the entrance to the cycle, we have two pointers traverse at
    // the same speed -- one from the front of the list, and the other from
    // the point of intersection.
    ListNode ptr1 = head;
    ListNode ptr2 = intersect;
    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return ptr1;
  }

    public ListNode detectCycle2(ListNode head) {
    Set<ListNode> visited = new HashSet<ListNode>();

    ListNode node = head;
    while (node != null) {
      if (visited.contains(node)) {
        return node;
      }
      visited.add(node);
      node = node.next;
    }

    return null;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(detectCycle(ls4));
    ls2.next=ls4;
    System.out.println(detectCycle(ls4));
  }
}