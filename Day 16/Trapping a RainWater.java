// Trapping a Rainwater a Leetcode Hard Prolem 
// Heights array are given we need to return the amount of water is trapped between the heights

// Approach 1: Brute force 
// Calculate for every point which is the maxLeft on left side and maxRight on rightSide
// Now find min of maxLeft and MaxRight and remove height on the perticular index from it add it to the result
// return the result

// Time Complexity- O(N^2)
// Space Complexity - O(1)

// Approach 2: Use suffix and prefix array to store the maxLeft and maxRight heights so no need to calculate for every time we can get it in O(1) time
// Time Complexity- O(N)+O(N)+O(N) => O(N)
// Space Complexity-  O(2N)

// Approach 3 : Optimal Approach 
// Use two pointer approch assign left=0,right=n-1,maxLeft=0,maxRight=0
// Now while left<=right
//           if height[left]<=height[right] 
//             if maxLeft<=height[left] update maxLeft = height[left];
//             else res+= (maxLeft-height[left])
//             left++;
//           else 
//             if maxRight<=height[right] update maxRight = height[right]
//             else res+= (maxRight-height[right])
//             right--;
//At end return the res

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code:-

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left=0,right=n-1,maxLeft=0,maxRight=0,res=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxLeft){
                  maxLeft = height[left];  
                } 
                else{
                  res = res + (maxLeft  - height[left]);
                } 
                left++;
            }
            else{
                if(height[right]>=maxRight){
                  maxRight = height[right];  
                } 
                else{
                  res =res+ ( maxRight - height[right]);  
                } 
                right--;
            }
        }
        return res;
    }
}

// Code 
