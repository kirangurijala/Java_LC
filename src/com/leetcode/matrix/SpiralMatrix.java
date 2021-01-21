package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(arr));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int nr = matrix.length;
        int nc = matrix[0].length;
        int l = 0, r = nc - 1, u = 0, d = nr - 1;
        int size = nr * nc;
        while (result.size() < size) {
            for (int i = l; i <= r && result.size() < size; i++) {
                result.add(matrix[u][i]);
            }
            for (int i = u + 1; i <= d - 1 && result.size() < size; i++) {
                result.add(matrix[i][r]);
            }
            for (int i = r; i >= l && result.size() < size; i--) {
                result.add(matrix[d][i]);
            }
            for (int i = d - 1; i >= u + 1 && result.size() < size; i--) {
                result.add(matrix[i][l]);
            }

            l++;
            u++;
            r--;
            d--;
        }
        return result;
    }
}