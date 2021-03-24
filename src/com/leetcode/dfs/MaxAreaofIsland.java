package com.leetcode.dfs;

/*
https://leetcode.com/problems/max-area-of-island/

Given a non-empty 2D array grid of 0s and 1s, an island is a group of 1s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50
*/
public class MaxAreaofIsland {
    public static void main(String[] args) {
        MaxAreaofIsland solution = new MaxAreaofIsland();
        int arr[][] = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        System.out.println(solution.maxAreaOfIsland(arr));
    }

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    dfs(grid,i,j, 0);
                }
            }
        }

        return max;
    }
    int max=0;
    private void dfs(int[][] grid, int i, int j,int n) {
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0){
            return;
        }

        grid[i][j]=0;
        n++;
        dfs(grid, i+1, j,n);
        dfs(grid, i-1, j,n);
        dfs(grid, i, j+1,n);
        dfs(grid, i, j-1,n);
        max=Math.max(max,n);
    }
}