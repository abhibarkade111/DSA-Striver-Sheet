//Problem statement: Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the top.

// Input: heights[] = [20, 30, 40, 20] 
// Output: 20
// Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
// jump from stair 0 to 1: cost = |30 - 20| = 10
// jump from stair 1 to 3: cost = |20-30|  = 10
// Total Cost = 10 + 10 = 20

// 1st approach : recursive approach
class Solution {
    int findAns(int ind, int height[]){
        if(ind==0) return 0;
        int step1 = findAns(ind-1,height)+Math.abs(height[ind]-height[ind-1]);
        int step2 = ind>1?findAns(ind-2,height)+Math.abs(height[ind]-height[ind-2]):Integer.MAX_VALUE;
        return Math.min(step1,step2);
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        return findAns(n-1,height);
    }
}
// Time complexity: O(2^n)
// Space complexity: O(n)

//2nd Approach: Recursive + Memoization
class Solution {
    int findAns(int ind, int height[], int dp[]){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int step1 = findAns(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        int step2 = ind>1?findAns(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]):Integer.MAX_VALUE;
        return dp[ind] = Math.min(step1,step2);
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return findAns(n-1,height,dp);
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

//3rd Approach: Tabulation
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n==1) return 0;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[1]-height[0]);
        for(int i=2;i<n;i++){
            int step1 = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int step2 = dp[i-2]+Math.abs(height[i]-height[i-2]);
            dp[i] = Math.min(step1,step2);
        }
        return dp[n-1];
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

// Approach 4: Space optimization
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n==1) return 0;
        int prev1 = 0;
        int prev2 = Math.abs(height[1]-height[0]);
        for(int i=2;i<n;i++){
            int step1 = prev2+Math.abs(height[i]-height[i-1]);
            int step2 = prev1+Math.abs(height[i]-height[i-2]);
            int curr = Math.min(step1,step2);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
// Time complexity: O(n)
// Space complexity: O(1)