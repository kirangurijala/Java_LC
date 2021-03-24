package com.leetcode.matrix;

/*
https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/
public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.searchMatrix(arr, 10));
        System.out.println(solution.searchMatrix(arr, 12));
        System.out.println(solution.searchMatrix(arr, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;

        // binary search
        int left = 0, right = rows * cols - 1, mid, midElement;
        while (left<=right){
            mid=(left+right)/2;
            midElement=matrix[mid/cols][mid%cols];
            if (target == midElement)
                return true;
            if (target < midElement)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}