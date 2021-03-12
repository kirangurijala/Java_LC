package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix-ii/

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]


*/
public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        int[][] result=solution.generateMatrix(3);
        for (int[] arr:result) {
            for (int n:arr) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int curr=1;
        int l = 0, r = n - 1, u = 0, d = n - 1;
        while (curr <= n*n) {
            for (int i = l; i <= r && curr <= n*n; i++) {
                matrix[u][i]=curr++;
            }
            for (int i = u + 1; i <= d - 1&& curr <= n*n; i++) {
                matrix[i][r]=curr++;
            }
            for (int i = r; i >= l && curr <= n*n; i--) {
                matrix[d][i]=curr++;
            }
            for (int i = d - 1; i >= u + 1 && curr <= n*n; i--) {
                matrix[i][l]=curr++;
            }

            l++;
            u++;
            r--;
            d--;
        }
        return matrix;
    }
}