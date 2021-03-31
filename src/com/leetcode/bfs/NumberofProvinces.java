package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-provinces/

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */
public class NumberofProvinces {
    //Time complexity : O(n^2). The complete matrix of size n^2is traversed.
    //Space complexity : O(n). A queuequeue and visitedvisited array of size n is used.
    public int findCircleNum(int[][] M) {
        if(M==null ||M.length==0){
            return 0;
        }

        int count=0;
        boolean[] visited=new boolean[M.length];
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if(visited[i]){
                continue;
            }

            q.add(i);
            while (!q.isEmpty()){
                int val=q.poll();
                visited[val]=true;
                for (int j = 0; j < M.length; j++) {
                    if(M[val][j]==1 && !visited[j])
                        q.add(j);
                }
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberofProvinces solution = new NumberofProvinces();
        int arr[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution.findCircleNum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}