// Single Element in a Sorted Array
// Input: arr = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Approach 1:
// Use xor operation on each elements
// Return the last remaining xor after performing the xor 

// Time Complexity- O(N)
// Space Complexity- O(1)

// Code:

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
       int n = arr.size();
        int x=0;
        for(int i=0;i<n;i++){
            x=x^arr.get(i);
        }
        return x;
    }
}

// Approach 2:
// Use Binary Search on array and according find we are present on left half or right half
// Do the binary search

// Time Complexity - O(logN)
// Space Complexity - O(1)

// Code:

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high = nums.length-2;
        while(low<=high){
            int mid = (low+high)>>1;
            if(nums[mid]==nums[mid^1]){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return nums[low];
    }
}