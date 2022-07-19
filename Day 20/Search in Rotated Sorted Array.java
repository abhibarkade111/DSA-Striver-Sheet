// Search in Rotated Sorted Array
// Input: arr= [4,5,6,7,0,1,2] and target=0
// Output: 4

// Appraoch 1: Linear Search
// Time Complexity - O(N)
// Space Complexity - O(1)

// Approach 2: Binary Search
// We use the binary search and check whther the left half is sorted or not if sorted then decide in which part the target lies if target lies in right half or left half and accordingly manage the left and right
// Return the index of target

// Time Complexity - O(logN)
// Space Complexity - O(1)

// Code:

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target>=nums[mid]&& target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}