package com.leetcode.matrix;

/*
https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

*/
public class Search2DMatrixII {
    public static void main(String[] args) {
        Search2DMatrixII solution = new Search2DMatrixII();
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.searchMatrix(arr, 10));
        System.out.println(solution.searchMatrix(arr, 12));
        System.out.println(solution.searchMatrix(arr, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int col=matrix[0].length-1,row=0;
        while(col>=0&&row<matrix.length){
            if(matrix[row][col]>target){
                col--;
            }else if(matrix[row][col]<target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix33(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }
        return false;
    }
}