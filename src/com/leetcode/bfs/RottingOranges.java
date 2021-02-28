package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/
public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int arr[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution.orangesRotting(arr));
    }

    public int orangesRotting(int[][] grid) {
//add rotten to q and freshCount fresh
        int freshCount= 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        //return zero if there are no fresh oranges
        if (freshCount == 0) {
            return 0;
        }

        int res = 0;
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//traverse 4 directions
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + point[0];
                    int y = dir[1] + point[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                    freshCount--;
                }
            }
        }

        //Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
        if (freshCount == 0) {
            return res - 1;
        }

        return -1;
    }
}