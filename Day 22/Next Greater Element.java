// Next Greater Element 

// Given array we need to find the frist greter elemnt on right

// Approach 1: Brute Force
// Use For loop and check entire array for the first greater element on right 

// Time Complexity- O(n*n)
// Space Complexity - O(1)

// Approach 2: Use Stack

// Time Complexity - O(2n)
// Space Compelxity- o(n)

// Code:

public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            ans[i]= st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return ans;
		
	}

}
