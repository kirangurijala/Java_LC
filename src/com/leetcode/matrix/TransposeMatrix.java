package com.leetcode.matrix;

/*
https://leetcode.com/problems/transpose-matrix/
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.





Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
*/
public class TransposeMatrix {
//    The idea is simple. For each row, use two pointers. One is going forward and the other is going backward.
//            (1). If the two elements are the same, then make a slight change like this 0 -> 1 or 1 -> 0.
//            (2). If the two elements are different, DON'T do anything. Just let it go.
//
//    Only scan the whole matrix once.

    public int[][] transpose(int[][] A) {
        int cols=A[0].length,rows=A.length;
        int[][] ans = new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans[j][i]=A[i][j];
            }
        }

        return ans;
        }
    public static void main(String[] args) {
        TransposeMatrix solution = new TransposeMatrix();
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solution.transpose(arr);
        System.out.println(arr);
    }
}