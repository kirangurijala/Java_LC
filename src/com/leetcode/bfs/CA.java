package com.leetcode.bfs;

/*

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

             15
             |
         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11
[3   1,2]
[6   5,3]
[7   5]
[5   4]
[9   4]
[11  9,4]


parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9),(15, 13)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
    (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false

n: number of pairs in the input

*/

import java.util.*;

public class CA {
    public static void main(String[] argv) {
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
                {15, 13}
        };

        int[][] parentChildPairs2 = new int[][] {
                {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
                {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };

        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8) == false);
   System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8) == true);
   System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8) == true);
   System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9) == true);
   System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3) == false);
   System.out.println(hasCommonAncestor(parentChildPairs1, 3, 1) == false);
   System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11) == true);
   System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5) == true);
   System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6) == true);
        System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12) == true);
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6) == false);
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12) == false);

    }

    private static List<Integer> getAncestors(Map<Integer, List<Integer>> map, int num){
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        q.add(num);
        while(!q.isEmpty()){
            int n=q.poll();
            list.add(n);
            if(map.get(n)==null){
                continue;
            }
            for(int ancestor:map.get(n)){
                q.add(ancestor);
            }
        }

        return list;
    }

    private static boolean hasCommonAncestor(int[][] parentChildPairs,int num1, int num2){
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] pair:parentChildPairs){
            List<Integer> temp=map.getOrDefault(pair[1], new ArrayList<>());
            temp.add(pair[0]);
            map.put(pair[1], temp);
        }

        List<Integer> list1=getAncestors(map,num1);
        List<Integer> list2=getAncestors(map,num2);

          System.out.println(list1);
      System.out.println(list2);
        for (int n:list1) {
            if(n==num1 || n==num2){
                continue;
            }
            if(list2.contains(n)){
                return true;
            }
        }

        return false;
    }
}
