// Sudoku Solver
// We need to fill the sudoku 9*9 
// Conditions: 1) Every row 1-9 digit and every digit appears once
//             2) Every col 1-9 digit and every digit appears once
//             3) Every 9*9 matrix contain 9 3*3 small matrix which contains 1-9 digit and each digit appears exactly once

// Appraoch: using Recursion we can easily fill the Sudoku
// We check for the empty column and try to fill the 1-9 digit which digit possible we can fill it so same continuasly until entire sudoku is filled

// Code :

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)==true) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char board[][],int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c) return false;
            if(board[row][i]==c) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
            
        }
        return true;
    }
}