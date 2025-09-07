//Problem statement:  This is a follow-up question to “Frog Jump” discussed in the previous article. In the previous question, the frog was allowed to jump either one or two steps at a time. In this question, the frog is allowed to jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.

//3rd Approach: Tabulation
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n==1) return 0;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[1]-height[0]);
        for(int i=1;i<n;i++){
          int minSteps = Integer.MAX_VALUE;
          for(int j=1;j<=k;j++){
            if(i-j>0) xminSteps = Math.min(minSteps,dp[i-1]+Math.abs(height[i]-height[i-1]));
          }
          dp[i] = minSteps;
        }
        return dp[n-1];
    }
}
// Time complexity: O(n*k)
// Space complexity: O(n*k)
