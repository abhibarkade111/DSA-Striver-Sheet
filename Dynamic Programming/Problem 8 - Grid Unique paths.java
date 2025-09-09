// Problem statement: There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

//Example
// Input: m = 3, n = 7
// Output: 28

//Approch 1: Recursive
class Solution {
    public int findAns(int row, int col, int m, int n){
        if(row==m-1 && col==n-1) return 1;
        if(row==m || col==n) return 0;
        return findAns(row+1,col,m,n)+findAns(row,col+1,m,n);
    }
    public int uniquePaths(int m, int n) {
        return findAns(0,0,m,n);
    }
}
//Time complexity: O(2^(m+n))
//Space complexity: O(m+n)

// Approach 2: Memoization
class Solution {
    public int findAns(int row, int col, int m, int n, int dp[][]){
        if(row==m-1 && col==n-1) return 1;
        if(row==m || col==n) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col] = findAns(row+1,col,m,n,dp)+findAns(row,col+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i[] : dp) Arrays.fill(i,-1);
        return findAns(0,0,m,n,dp);
    }
}
// Time complexity: O(M*N)
// Space Complexity: O(N*M)

//Approach 3: Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        // for(int i[] : dp) Arrays.fill(i,-1);
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[0][j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
//Time complexity: O(m*n);
//Space complexity: O(m*n)

//Approach 4: Space optimization
class Solution {
  public int uniquePaths(int m, int n) {
        int prevR[] = new int[n+1];
        for(int i=0;i<n;i++) prevR[i]=1;
        for(int i=1;i<m;i++){
            int row[] = new int[n+1];
            for(int j=0;j<n;j++){
                row[j] = prevR[j];
                if(j>0) row[j]+=row[j-1];
            }
            prevR = row;
        }
        return prevR[n-1];
    }
}
//Time complexity: O(m*n)
//Space Complexity: O(n)
