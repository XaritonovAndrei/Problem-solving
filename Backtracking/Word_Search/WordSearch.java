package com.problem_solving.Backtracking.Word_Search;

//Given an m x n grid of characters board and a string word,
// return true if word exists in the grid.

//The word can be constructed from letters of sequentially adjacent cells,
// where adjacent cells are horizontally or vertically neighboring.
// The same letter cell may not be used more than once.

//Example 1:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true

//Example 2:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true

//Example 3:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//Output: false

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'F'},{'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(search(board, word));
    }


    public static boolean search(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row++){
            for(int column = 0; column < cols; column++) {
                if(backtrack(row, column, word, 0, rows, cols, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int row, int col, String word, int index, int rows, int cols, char[][] board){

        if(index >= word.length()){
            return true;
        }

        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        int [] rowdir = {0,1,0,-1};
        int[] coldir = {1,0,-1,0};
        board[row][col] = '#';

        boolean ret = false;

        for(int d = 0; d < 4; d++){
            ret = backtrack(row + rowdir[d], col + coldir[d], word, index+1, rows, cols, board);
            if(ret){
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return ret;
    }
}
