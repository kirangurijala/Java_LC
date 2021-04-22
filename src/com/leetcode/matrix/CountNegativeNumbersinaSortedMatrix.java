package com.leetcode.matrix;

/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 */
public class CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count=0, rows= grid.length, cols=grid[0].length, row=rows-1, col=0;
        while(row>=0&&col<cols){
            if(grid[row][col]<0){
                count=count+cols-col;
                row--;
            }else {
                col++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountNegativeNumbersinaSortedMatrix solution = new CountNegativeNumbersinaSortedMatrix();
        int[] arr={1,2,3};

        System.out.println(solution.countNegatives(null));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}