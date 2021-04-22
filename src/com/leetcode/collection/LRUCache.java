package com.leetcode.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
https://leetcode.com/problems/lru-cache/
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

Follow up:
Could you do get and put in O(1) time complexity?



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

 */
public class LRUCache{
  class DLinkNode {
    int key;
    int value;
    DLinkNode prev;
    DLinkNode next;
  }
  void addNode(DLinkNode node){
    node.prev=head;
    node.next=head.next;
    head.next.prev=node;
    head.next=node;
  }

  void removeNode(DLinkNode node){
    DLinkNode pre=node.prev;
    DLinkNode next=node.next;

    pre.next=next;
    next.prev=pre;
  }

  void moveToHead(DLinkNode node){
    removeNode(node);
    addNode(node);
  }

  DLinkNode popTail(){
    DLinkNode res=tail.prev;
    removeNode(res);
    return  res;
  }

  Map<Integer,DLinkNode> cache=new HashMap<>();
  DLinkNode head;
  DLinkNode tail;
  int capacity;
  LRUCache(int capacity){
    head=new DLinkNode();
    tail=new DLinkNode();
    head.next=tail;
    tail.prev=head;
    this.capacity=capacity;
  }

  int get(int key){
    DLinkNode node= cache.get(key);
    if(node==null){
      return -1;
    }

    moveToHead(node);
    return node.value;
  }

  void put(int key,int value){
    DLinkNode node=cache.get(key);
    if(node!=null){
      node.value = value;
      moveToHead(node);
      return;
    }

    DLinkNode newNode=new DLinkNode();
    newNode.key=key;
    newNode.value=value;
    cache.put(key,newNode);
    addNode(newNode);
    if(cache.size()>capacity){
      DLinkNode tail = popTail();
      cache.remove(tail.key);
    }
  }
}
class LRUCache2 extends LinkedHashMap<Integer,Integer> {
  /*
   * Extend LRU class to LinkedHash <int,int>
   * LRUCache constructor, cal super metho by passing capacity,loadfact(0.75f),assessorder true(LRU)
   * get, cal super.getOrDefault with default -1
   * put, cal super.put
   * Add a over ride method removeEldestEntry with parameter Map.Entry<int,int>
   *  return size()>capacity
   * Time complexity of get or put: O(1)
   * Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements
   */
  int capacity=0;
  public LRUCache2(int capacity){
    super(capacity,0.75f,true);
    this.capacity=capacity;
  }
  public int get(int key){
    return super.getOrDefault(key,-1);
  }
  public void put(int key,int value){
    super.put(key,value);
  }

  @Override
  protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
    return size()>capacity;
  }
}
