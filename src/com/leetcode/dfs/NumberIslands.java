package com.leetcode.dfs;

/*
https://leetcode.com/problems/number-of-islands/

Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
public class NumberIslands {
    /*
     * Apply DFS
     * loop through row and cols to find the element '1'
     *      increment counter, pass the position of i,j to dfs recursive funtion to make all connected to 1 to zero.
     * return count;
     * DFS:
     *      check base conditions that wee don't need to travel (i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]=='0')
     *      call recursively 4 sides(left,right up,down)
     * Time complexity : O(m*n)
     * Space complexity : O(1)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count=0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
    public static void main(String[] args) {
        NumberIslands solution = new NumberIslands();
        char arr[][] = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(arr));
    }
}