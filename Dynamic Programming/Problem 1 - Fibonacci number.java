// 1st approach : recursive approach
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
}
// Time complexity: O(2^n)
// Space complexity: O(n)

//2nd Approach: Recursive + Memoization
class Solution {
    public int findFibNumber(int n, int dp[]){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return findFibNumber(n-1,dp)+findFibNumber(n-2,dp);
    }
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return findFibNumber(n,dp);
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

//3rd Approach: Tabulation
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

// Approach 4: Space optimization
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev1 = 0;
        int prev2 = 1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int curr = prev1+prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
// Time complexity: O(n)
// Space complexity: O(1)