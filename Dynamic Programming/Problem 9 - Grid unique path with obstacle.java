// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//Example
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

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
    public int findAns(int r, int c, int m, int n, int arr[][], int dp[][]){
        if(r==m || c==n || arr[r][c]==1) return 0;
        if(r==m-1 && c==n-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c] = findAns(r+1,c,m,n,arr,dp)+findAns(r,c+1,m,n,arr,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n=obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i[] : dp) Arrays.fill(i,-1);
        if(obstacleGrid[m-1][n-1]==1) return 0;
        return findAns(0,0,m,n,obstacleGrid,dp);
    }
}
// Time complexity: O(M*N)
// Space Complexity: O(N*M)

//Approach 3: Tabulation
class Solution {
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n=obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<n;i++) if(obstacleGrid[0][i]!=1) dp[0][i]=1; else break;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                if(j>0) row[j]+=row[j-1];
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
            }
        }
        return dp[m-1][n-1];
    }
}
//Time complexity: O(m*n);
//Space complexity: O(m*n)

//Approach 4: Space optimization
class Solution {
   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n=obstacleGrid[0].length;
        int prevR[] = new int[n+1];
        for(int i=0;i<n;i++) if(obstacleGrid[0][i]!=1) prevR[i]=1; else break;
        for(int i=1;i<m;i++){
            int row[] = new int[n+1];
            for(int j=0;j<n;j++){
                row[j] = prevR[j];
                if(j>0) row[j]+=row[j-1];
                if(obstacleGrid[i][j]==1) row[j]=0;
            }
            prevR = row;
        }
        return prevR[n-1];
    }
}
//Time complexity: O(m*n)
//Space Complexity: O(n)
