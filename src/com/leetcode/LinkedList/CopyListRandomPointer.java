package com.leetcode.LinkedList;




import java.util.HashMap;
import java.util.Map;


/*
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.



Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.

    */
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public  class CopyListRandomPointer {
  /*
   * Assign node to Head to keep track of elements
   * Create a nodes map, put curr node and a new node with current node val, node=node.next
   * loop through map keys assign next,rondom to map of node.next,node.rondom
   * return nodes.get(head)
   * Time complexity : O(n)
   * Space complexity : O(n)
   */
    public Node copyRandomList(Node head) {
      Map<Node,Node> nodes=new HashMap<>();
      Node curr=head;
      while(curr!=null){
        nodes.put(curr,new Node(curr.val));
        curr=curr.next;
      }

      for(Node node: nodes.keySet()){
        nodes.get(node).next=nodes.get(node.next);
        nodes.get(node).random=nodes.get(node.random);
      }

      return nodes.get(head);
    }

  public Node iterataecopyRandomList(Node head) {
    if(head ==null){
      return null;
    }
    Map<Node,Node> nodes=new HashMap<>();
    Node node=head;
    while(node!=null){
      nodes.put(node,new Node(node.val));
      node=node.next;
    }

    node=head;
    while(node!=null){
      nodes.get(node).next= nodes.get(node.next);
      nodes.get(node).random= nodes.get(node.random);
      node=node.next;
    }

    return nodes.get(head);
  }


  public static void main(String[] args) {
    Node ls1=new Node(1);

    CopyListRandomPointer cp=new CopyListRandomPointer();
    System.out.println(cp.copyRandomList(ls1));
  }
}