// Remove duplicate element from unsorted array
// 1,1,2,2,2,3,3 => 1,2,3,_,_,_,_

// Approach 1: Use HashSet
// Store All elemnts in hashSet and now get element from the hashSet and update array
// return the unique elements

// Time Complexity- O(N)
// Space Complexity- O(N)

// Approach 2: Two pinter Approach 
// intialize i=0,j=1;
// using for loop travrse the using j
// if arr[i]!=arr[j] then update arr[i+1] = arr[j] and i++;
// return i+1;

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code :- 

public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		// Write your code here.
        int i=0;
        if(n==0) return 0;
        for(int j=1;j<n;j++){
            if(arr.get(i)!=arr.get(j)){
                i++;
                arr.set(i,arr.get(j));
            }
        }
        return i+1;
	}
}