// N-Queen problem - recursion and backtracking
// only size of chessboard is given i.e n*n chessboard 
// We need to find the how many possible solution are there so no queen can attack each other
// Queen can attack each in straight line and digonally

// Apparoch 1:
// Using recursion we can check each position is safe or not 
// But if we check for each position it can take more time

// Approach 2: Optimal Apparoch
// Use Hashing to check whether if queen can be placed at perticula position or not
// we use row Array, upperDigoanl array and loweDigonal array to check the queen position is safe or not

// Code:

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int rowL[] = new int[n];
        int upperD[] = new int[2*n-1];
        int lowerD[] = new int[2*n-1];
        solve(0, board, res, rowL, upperD, lowerD);
        return res;
    }
    
    public void solve(int col, char board[][], List<List<String>> res, int rowL[], int upperD[], int lowerD[]){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(rowL[row]==0 && lowerD[row+col]==0 && upperD[board.length-1 + col-row]==0){
                board[row][col]  = 'Q';
                rowL[row] = 1;
                lowerD[row+col]=1;
                upperD[board.length-1+col-row]=1;
                solve(col+1, board, res, rowL, upperD, lowerD );
                board[row][col] = '.';
                rowL[row]=0;
                lowerD[row+col]=0;
                upperD[board.length-1+col-row]=0;
            }
        }
    }
    
    public static List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}