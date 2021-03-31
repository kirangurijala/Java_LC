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

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public  class MergekSortedLists {
  /*
   * split array into 2, recurrsion on splited on arrray until it has one or twoelements
   *  if one element return,twoelements merge those elements
   * Time complexity : (KN) where k is the number of linked lists.
   * Space complexity : O(1)
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length==0) {
      return null;
    }
    if (lists.length==1){
      return lists[0];
    }
    if (lists.length==2){
      return  mergeTwoLists(lists[0], lists[1]);
    }
    ListNode[] a = Arrays.copyOfRange(lists, 0, (lists.length + 1)/2);
    ListNode[] b = Arrays.copyOfRange(lists, (lists.length + 1)/2, lists.length);
    return mergeTwoLists(mergeKLists(a),mergeKLists(b));
  }
  /*
   * Create a preHead (-1) to keep track of result link list, create l to iterate prehead
   * loop through l1&&L2 not null
   *  if l1 val is less than or equal l2 val, assign l1 to l.next..i.e l1.next=l1,else l.next=l2
   * After the loop check l1or l2 null, if l1 is null l.next=l2, else l.next =l1
   * return preHead.next(Don't return l beacuse l is used only for iteration when it reaches end its val is null)
   * Time complexity : O(n + m)
   * Space complexity : O(1)
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // maintain an unchanging reference to node ahead of the return node.
    ListNode prehead = new ListNode(-1);
    ListNode l = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        l.next = l1;
        l1 = l1.next;
      } else {
        l.next = l2;
        l2 = l2.next;
      }
      l = l.next;
    }

    // exactly one of l1 and l2 can be non-null at this point, so connect
    // the non-null list to the end of the merged list.
    if(l1!=null){
      l.next=l1;
    }else{
      l.next=l2;
    }

    return prehead.next;
  }

  /*
   * loop through all list
   *  Add values to PriorityQueue
   * Create a preHead (-1) to keep track of result link list, Assign curr to prehead to iterate the prehead
   * loop through PriorityQueue
   *  Add nodes to curr (curr.next=new ListNode(pq.poll()),curr=curr.next)
   * return preHead.next(Don't return curr beacuse curr is used only for iteration when it reaches end its val is null)
   * Time complexity : (Nlogk) where k is the number of linked lists.
   * Space complexity : O(n)
   */
  public ListNode priorityQueueMergeKLists(ListNode[] lists) {//
      Queue<Integer> q=new PriorityQueue<>();
      for(ListNode ls:lists){
        while(ls!=null){
          q.add(ls.val);
          ls=ls.next;
        }
      }

      ListNode preHead=new ListNode(0);
      ListNode curr=preHead;
      while(!q.isEmpty()){
        curr.next=new ListNode(q.poll());
        curr=curr.next;
      }

      return preHead.next;
    }

  /*
   * loop through all list
   *  Add values to nodes list
   * Create a preHead (-1) to keep track of result link list, Assign curr to prehead to iterate the prehead
   * loop through nodes
   *  Add nodes to curr (curr.next=new ListNode(node.val),curr=curr.next)
   * return preHead.next(Don't return curr beacuse curr is used only for iteration when it reaches end its val is null)
   * Time complexity : (NlogN) where N is the number of linked nodes.
   * Space complexity : O(n)
   */
  public ListNode bruteForceMergeKLists(ListNode[] lists) {//
    List<ListNode> nodes=new ArrayList<>();
    for(ListNode ls:lists){
      while(ls!=null){
        nodes.add(ls);
        ls=ls.next;
      }
    }

    Collections.sort(nodes,(a,b)->a.val-b.val);

    ListNode preHead=new ListNode(0);
    ListNode curr=preHead;
    for(ListNode node:nodes){
      curr.next=new ListNode(node.val);
      curr=curr.next;
    }

    return preHead.next;
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