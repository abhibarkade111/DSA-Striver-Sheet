// Max Consecutive Ones

// Apparoach 1:
// steps : 1) Intialize count-0,max=0
//         2) if arr[i]==1 count++;
//         3) else max  = Math.max(max, count0) and count=0

// Code :-
// Leetcode

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0;
        int max=0;
        while(j<nums.length){
            while(i<nums.length && nums[i]!=1) i++;
            j=i;
            while(j<nums.length && nums[j]==1) j++;
            max = Math.max(max,j-i);
            i=j;
        }
        return max;
    }
}


// CodeStudio

import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
        int max=0;
        int i=0;
        int j=0;
        while(j<n){
            if(arr.get(j)==0) k--;
            if(k<0){
                while(arr.get(i)!=0) i++;
                i++;
                k++;
            }
            else{
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
       
	}
}