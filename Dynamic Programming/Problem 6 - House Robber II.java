// Problem statement: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

// As this is the follow up question of previous house robber question so we will do small modification in Tabulation + space optimisaion solution

// Approach 4: Space optimization
class Solution {
    public int findAns(int nums[]){
        if(nums.length==1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1= curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int arr1[] = new int[nums.length-1];
        int arr2[] = new int[nums.length-1];
        int j1=0,j2=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0) arr1[j1++] = nums[i];
            if(i!=nums.length-1) arr2[j2++] = nums[i];
        }
        return Math.max(findAns(arr1), findAns(arr2));
    }
}
// Time complexity: O(2n)
// Space complexity: O(2n)