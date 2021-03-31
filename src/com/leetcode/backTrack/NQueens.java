package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/n-queens/
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 */
public class NQueens {
    public List<List<Integer>> nQueens(int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n, list,0,new ArrayList<Integer>());
        return list;
    }
    private void backtrack(int n, List<List<Integer>> list , int row, List<Integer> cellPlacements) {
        if(row==n){
            list.add(new ArrayList<>(cellPlacements));
            return;
        }

        for (int col = 0; col < n ; col++) {
            cellPlacements.add(col);
            if(isValid(cellPlacements)){
                backtrack(n,list,row+1,cellPlacements);
            }
        }

        cellPlacements.remove(cellPlacements.size()-1);
    }

    private boolean isValid(List<Integer> cellPlacements) {
        int rowId=cellPlacements.size()-1;
        for (int i = 0; i < rowId ; i++) {
            int diff=Math.abs(cellPlacements.get(i)- cellPlacements.get(rowId));
            if(diff==0 || diff==rowId-i){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        NQueens solution = new NQueens();
        System.out.println(solution.nQueens(4));
    }
}