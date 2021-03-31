package com.leetcode.dp;

/*
https://leetcode.com/problems/minimum-path-sum/
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.



Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 100

*/
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(arr));
    }
    public int minPathSum(int[][] grid) {
        int nr=grid.length,nc=grid[0].length;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(i==0 && j!=0){
                    grid[0][j]=grid[0][j-1]+grid[0][j];
                }else if(j==0 && i!=0){
                    grid[i][0]=grid[i-1][0]+grid[i][0];
                }else if(j!=0 && i!=0){
                    grid[i][j]= grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }

        return grid[nr-1][nc-1];
    }
    public int minPathSum2(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = nr - 1; i >= 0; i--) {
            for (int j = nc - 1; j >= 0; j--) {
                if (i == nr - 1 && j != nc - 1) {
                    grid[nr - 1][j] += grid[nr - 1][j + 1];
                } else if (i != nr - 1 && j == nc - 1) {
                    grid[i][nc - 1] += grid[i + 1][nc - 1];
                } else if (i != nr - 1 && j != nc - 1) {
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }

        return grid[0][0];
    }
}