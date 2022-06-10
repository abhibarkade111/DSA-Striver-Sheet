// Kedane's algorithm used to find the maximum subarray sum 
// It's most popular solution to find maximum subarray sum in linear time comolexity

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
        int maxSum=0;
        int currSum = arr[0];
        for(int i=1;i<n;i++){
            if(currSum<0){
                currSum=0;
            }
            currSum+=arr[i];
            if(maxSum<currSum){
                maxSum=currSum;
            }
        }
        return maxSum;
	}

}


// Time Complexity O(n)