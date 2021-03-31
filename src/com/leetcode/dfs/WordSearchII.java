package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/word-search/

The word can be constructed from letters of sequentially adjacent cells, where 'adjacent' cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
Output: true

Example 2:
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
Output: true

Example 3:
Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
Output: false

*/
public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();
        char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //System.out.println(solution.exist(arr, "ABCCED"));
    }

    List<String> res= new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null ||board.length==0){
            return res;
        }

        TrieNode root=new TrieNode();
        buildtrie(root,words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c=board[i][j];
                if(root.children[c-'a']!=null){
                    dfs(board,i,j,root);
                }
            }
        }
        return res;
    }


    private void dfs(char[][] board, int i, int j, TrieNode root){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;

        char c=board[i][j];
        if(c=='#') return;


        if(root.children[c-'a'] ==null) return;
        root= root.children[c-'a'];
        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        board[i][j] ='#';
        dfs(board,i+1,j,root);
        dfs(board,i-1,j,root);
        dfs(board,i,j+1,root);
        dfs(board,i,j-1,root);
        board[i][j] = c;
    }

    private void buildtrie(TrieNode root,String[] words){
        for(String word:words){
            TrieNode cur=root;
            for(char c:word.toCharArray()){
                int index=(int)(c-'a');
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }

            cur.word = word;
        }
    }

    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

WordSearch ws=new WordSearch();
 public List<String> findWordsDFS(char[][] board, String[] words) {
     List<String> res = new ArrayList<>();
     for (String word : words) {
         if (ws.exist(board, word)) {
             res.add(word);
         }
     }
     return res;
    }
}