package com.leetcode.matrix;

/*
https://leetcode.com/problems/maximal-square/

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.



Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:

Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:

Input: matrix = [["0"]]
Output: 0
*/
public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();
        char arr[][] = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(solution.maximalSquare(arr));
    }
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m=a.length,n=a[0].length, max=0;
        int[][] b=new int[m+1][n+1];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(a[i][j]=='1'){
                    b[i+1][j+1] = Math.min(Math.min(b[i+1][j], b[i][j]), b[i][j+1]) + 1;
                    max = Math.max(max, b[i+1][j+1]);
                }
            }
        }
        return max*max;

    }
    public int maximalSquareee(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}