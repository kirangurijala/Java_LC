package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
public class SpiralMatrix {
// This is a very simple and easy to understand solution. I traverse right and increment rowBegin, then traverse down and decrement colEnd, then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.

// The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. If anyone can do the same thing without that check, please let me know!

    // Any comments greatly appreciated.
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }


        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = cols - 1, u = 0, d = rows - 1;
        int size = rows * cols;
        while (res.size() < size) {
            //right
            for (int i = l; i <= r && res.size() < size; i++) {
                res.add(matrix[u][i]);
            }
            //down
            for (int i = u + 1; i <= d - 1 && res.size() < size; i++) {
                res.add(matrix[i][r]);
            }
            //left
            for (int i = r; i >= l && res.size() < size; i--) {
                res.add(matrix[d][i]);
            }
            //up
            for (int i = d - 1; i >= u + 1 && res.size() < size; i--) {
                res.add(matrix[i][l]);
            }

            l++;
            u++;
            r--;
            d--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(arr));
    }
}