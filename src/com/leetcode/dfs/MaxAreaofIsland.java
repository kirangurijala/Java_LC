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
    int n=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    n=0;
                    n=dfs(i,j,grid);
                    if(n>max){
                        max=n;
                    }
                }
            }
        }

        return max;
    }


    private int dfs(int r,int c,int[][] grid){
        int nr=grid.length;
        int nc=grid[0].length;
        if(r<0||c<0||r>=nr||c>=nc||grid[r][c]==0){
            return 0;
        }

        grid[r][c] = 0;
        n++;
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);

        return n;
    }


    public int maxAreaOfIsland3(int[][] grid) {
        int result = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int count = dfs3(grid, i, j);
                    if(count > result) result = count;
                }
            }
        }
        return result;
    }

    public int dfs3(int[][] grid, int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return dfs3(grid, i-1,j) + dfs3(grid, i,j-1) + dfs3(grid, i+1,j) + dfs3(grid, i,j+1)+1;
    }
}