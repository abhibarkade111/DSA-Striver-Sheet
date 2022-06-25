// Find The Unique paths from [0][0] to [m-1][n-1]
// We can Solve using three approaches
// 1) Brute Force
// Use Recursion function and call from each possible choice 

class Solution{
    public int uniquePaths(int m, int n) {
        return solve(0,0,m,n);
    }
    public int solve(int i,int j, int m, int n){
        if(i==(m-1) && j==(n-1)) return 1;
        if(i==(m-1) || j==(n-1)) return 0;
        else return solve(i+1,j,m,n)+solve(i,j+1,m,n);
    }
}
// Ṭime Complexity = Exponenetial
// Space Complexity = Exponenetial


// 2nd Approach:- Using Dyanamic programming
// As we see in the problem there is a overlapping subproblem so we can optimise it using DP
class Solution{
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        Arrays.fill(dp,-1);
        return solve(0,0,dp);
    }
    public int solve(int i,int j,int dp[][]){
        if(i==(m-1) && j==(n-1)) return 1;
        if(i>=(m-1) || j>=(n-1)) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        else return dp[i][j]=solve(i+1,j,dp)+solve(i,j+1,dp);
    }
}
// Time Complexity - O(m*n)
// Space complexity - O(m*n)


// Third Approach: Optimal Approach
// Google Will be interested in this Approach

class Solution {

    public int uniquePaths(int m, int n) {
        //Optimal Approach
        int N = m+n-2;
        int r=m-1;
        double res=1;
        for(int i=1;i<=r;i++){
            res=res*(N-r+i)/i;
        }
        return (int)res;
    }
}

// Time Complexity - O(m)
// Space Complexity - O(1)
