// 1st approach : recursive approach
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
// Time complexity: O(2^n)
// Space complexity: O(n)

//2nd Approach: Recursive + Memoization
class Solution {
    public int findAns(int n, int dp[]){
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = findAns(n-1,dp)+findAns(n-2,dp);
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return findAns(n,dp);
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

//3rd Approach: Tabulation
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[n] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

// Approach 4: Space optimization
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int prev1=1;
        int prev2=2;
        for(int i=3;i<=n;i++){
            int curr = prev1+prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
// Time complexity: O(n)
// Space complexity: O(1)