package com.leetcode.dfs;

import java.util.*;

/*
https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.



Example 1:

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:

Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0



Constraints:

    2 <= n <= 5 * 10^4
    connections.length == n-1
    connections[i].length == 2
    0 <= connections[i][0], connections[i][1] <= n-1
    connections[i][0] != connections[i][1]


*/
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public static void main(String[] args) {
        ReorderRoutestoMakeAllPathsLeadtotheCityZero solution = new ReorderRoutestoMakeAllPathsLeadtotheCityZero();
        int arr[][] = {{0,1},{1,3},{2,3},{4,0},{4,5}};


        System.out.println(solution.minReorder(6, arr));
    }
//[[0,1],[1,3],[2,3],[4,0],[4,5]]
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        Set<Integer> set;
        Set<String> path=new HashSet<>();
        for(int[] connection:connections){
            path.add(connection[0]+"->"+connection[1]);
            set=map.getOrDefault(connection[0],new HashSet<>());
            set.add(connection[1]);
            map.put(connection[0],set);

            set=map.getOrDefault(connection[1],new HashSet<>());
            set.add(connection[0]);
            map.put(connection[1],set);
        }

//       for (int[] c : connections) {
//            path.add(c[0] + "->" + c[1]);
//            map.computeIfAbsent(c[0], k -> new HashSet<>());
//            map.computeIfAbsent(c[1], k -> new HashSet<>());
//            map.get(c[0]).add(c[1]);
//            map.get(c[1]).add(c[0]);
//        }

        System.out.println(path);
        System.out.println(map);
        Queue<Integer> q=new LinkedList<>();
        q.add(0);

        boolean[] visted=new boolean[n];
        visted[0]=true;
        int count=0;
        while(!q.isEmpty()){
            int val=q.poll();
            for (int next:map.getOrDefault(val,new HashSet<>())) {
                if(visted[next]) continue;
                visted[next]=true;
                if(!path.contains(next+"->"+val)){
                    count++;
                }
                q.add(next);
            }
        }

        return count;
    }
}