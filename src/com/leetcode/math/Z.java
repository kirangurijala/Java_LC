package com.leetcode.math;

/*

 */
public class Z {
    public static void main(String[] args) {
        Z solution = new Z();
        ///System.out.println(solution.sol(23));
        char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(arr, "SEE"));
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]==word.charAt(0)&&dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(char[][] board, int i, int j,int count, String word) {
        if(count==word.length()){
            return true;
        }

        if(i<0||j<0||i>=board.length||j>=board[0].length|| board[i][j] != word.charAt(count)){
            return false;
        }

        count++;
        board[i][j] ='*';
        char ch=board[i][j];
        boolean isFound= dfs(board,i+1,j,count, word)||dfs(board,i-1,j,count, word)||dfs(board,i,j+1,count, word)||dfs(board,i,j-1,count, word);
        board[i][j] =ch;
        return isFound;
    }
}