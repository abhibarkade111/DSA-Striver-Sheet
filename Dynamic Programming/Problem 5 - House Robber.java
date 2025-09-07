// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// 1st approach : recursive approach
class Solution {
    public int findAns(int ind, int nums[], int n){
        if(ind>=n) return 0;
        int rob = nums[ind]+findAns(ind+2,nums,n);
        int doNotRob = findAns(ind+1,nums,n);
        return Math.max(rob,doNotRob);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        return findAns(0,nums,n);
    }
}
// Time complexity: O(2^n)
// Space complexity: O(n)

//2nd Approach: Recursive + Memoization
class Solution {
    public int findAns(int ind, int nums[], int n, int dp[]){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int rob = nums[ind]+findAns(ind+2,nums,n,dp);
        int doNotRob = findAns(ind+1,nums,n,dp);
        return dp[ind] = Math.max(rob,doNotRob);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return findAns(0,nums,n,dp);
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

//3rd Approach: Tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int rob = nums[i]+dp[i-2];
            int doNotRob = dp[i-1];
            dp[i] = Math.max(rob,doNotRob);
        }
        return dp[n-1];
    }
}
// Time complexity: O(n)
// Space complexity: O(n)

// Approach 4: Space optimization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int rob = nums[i]+prev1;
            int doNotRob = prev2;
            int curr = Math.max(rob,doNotRob);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
// Time complexity: O(n)
// Space complexity: O(1)