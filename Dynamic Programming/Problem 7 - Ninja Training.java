// Problem statement:Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Given a 2D array arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2] represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum total merit points Geek can achieve .

// Input: arr[]= [[1, 2, 5], [3, 1, 1], [3, 3, 3]]
// Output: 11
// Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.

//Approch 1: Recursive
class Solution {
    public int findAns(int ind, int last, int arr[][], int n){
        if(ind==n) return 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i!=last){
                ans = Math.max(ans, arr[ind][i]+findAns(ind+1,i,arr,n));
            }
        }
        return ans;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            ans = Math.max(ans, findAns(0,i,arr,n));
        }
        return ans;
    }
}
//Time complexity: O(3*2^n)
//Space complexity: O(n)

// Approach 2: Memoization
class Solution {
    public int findAns(int ind, int last, int arr[][], int n, int dp[][]){
        if(ind==n) return 0;
        int ans = Integer.MIN_VALUE;
        if(dp[ind][last]!=-1) return dp[ind][last];
        for(int i=0;i<3;i++){
            if(i!=last){
                ans = Math.max(ans, arr[ind][i]+findAns(ind+1,i,arr,n,dp));
            }
        }
        return dp[ind][last] = ans;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[n][3];
        for(int i[]:dp) Arrays.fill(i,-1);
        for(int i=0;i<3;i++){
            ans = Math.max(ans, findAns(0,i,arr,n,dp));
        }
        return ans;
    }
}
// Time complexity: O(N*3*3)
// Space Complexity: O(N*3)

//Approach 3: Tabulation
class Solution {
    public int findAns(int ind, int last, int arr[][], int n, int dp[][]){
        if(ind==n) return 0;
        int ans = Integer.MIN_VALUE;
        if(dp[ind][last]!=-1) return dp[ind][last];
        for(int i=0;i<3;i++){
            if(i!=last){
                ans = Math.max(ans, arr[ind][i]+findAns(ind+1,i,arr,n,dp));
            }
        }
        return dp[ind][last] = ans;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                int ans = Integer.MIN_VALUE;
                for(int k=0;k<3;k++){
                    if(k!=j){
                        ans = Math.max(ans, arr[i][j]+dp[i-1][k]);
                    }
                }
                dp[i][j] = ans;
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1],dp[n-1][2]));
    }
}
//Time complexity: O(n*3*3);
//Space complexity: O(n*3)

//Approach 4: Space optimization
class Solution {
    public int findAns(int ind, int last, int arr[][], int n, int dp[][]){
        if(ind==n) return 0;
        int ans = Integer.MIN_VALUE;
        if(dp[ind][last]!=-1) return dp[ind][last];
        for(int i=0;i<3;i++){
            if(i!=last){
                ans = Math.max(ans, arr[ind][i]+findAns(ind+1,i,arr,n,dp));
            }
        }
        return dp[ind][last] = ans;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int prev[] = new int[3];
        prev[0] = arr[0][0];
        prev[1] = arr[0][1];
        prev[2] = arr[0][2];
        for(int i=1;i<n;i++){
            int curr[] = new int[3];
            for(int j=0;j<3;j++){
                int ans = Integer.MIN_VALUE;
                for(int k=0;k<3;k++){
                    if(k!=j){
                        ans = Math.max(ans, arr[i][j]+prev[k]);
                    }
                }
                curr[j] = ans;
            }
            prev = curr;
        }
        return Math.max(prev[0], Math.max(prev[1],prev[2]));
    }
}
//Time complexity: O(n*3*3)
//Space Complexity: O(3)