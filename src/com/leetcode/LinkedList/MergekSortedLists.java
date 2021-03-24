package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

    */

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public  class MergekSortedLists {
  //Time complexity : O(kN)O(kN) where \text{k}k is the number of linked lists.
  //
  //We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
  //Sum up the merge process and we can get: O(\sum_{i=1}^{k-1} (i*(\frac{N}{k}) + \frac{N}{k})) = O(kN)O(∑
  //i=1
  //k−1
  //​
  // (i∗(
  //k
  //N
  //​
  // )+
  //k
  //N
  //​
  // ))=O(kN).
  //Space complexity : O(1)O(1)
  //
  //We can merge two sorted linked list in O(1)O(1) space.
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode head=null;
    ListNode former=null;
    while (l1!=null&&l2!=null) {
      if (l1.val>l2.val) {
        if (former==null) former=l2; else former.next=l2;
        if (head==null) head=former; else former=former.next;
        l2=l2.next;
      } else {
        if (former==null) former=l1; else former.next=l1;
        if (head==null) head=former; else former=former.next;
        l1=l1.next;
      }
    }
    if (l2!=null) l1=l2;
    former.next=l1;
    return head;

  }

  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.size()==0) return null;
    if (lists.size()==1) return lists.get(0);
    if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
    return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
            mergeKLists(lists.subList(lists.size()/2, lists.size())));
  }

  //Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
  //
  //The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
  //There are NN nodes in the final linked list.
  //Space complexity :
  //
  //O(n)O(n) Creating a new linked list costs O(n)O(n) space.
  //O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).

  public ListNode mergeKLists(ListNode[] lists) {//
    Queue<Integer> q=new PriorityQueue<>();
    for(ListNode ls:lists){
      while(ls!=null){
        q.add(ls.val);
        ls=ls.next;
      }
    }

   ListNode head=new ListNode(0);
    ListNode curr=head;
    while(!q.isEmpty()){
      curr.next=new ListNode(q.poll());
      curr=curr.next;
    }

return head.next;
  }



  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    MergekSortedLists sol=new MergekSortedLists();
    System.out.println(sol.mergeKLists(new ListNode[]{ls4,ls2}));
  }
}