// Longest Palindromic Substring 
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Approach 1: Check for even and odd index
// Time Complexity - O(n*n)
// Space Complexity - O(1)

// Code:

public class Solution {	
	public static String longestPalinSubstring(String str) {
		// Write your code here.
        String ans="";
        for(int i=0;i<str.length();i++){
            String temp = Helper(str,i,i);
            if(temp.length()>ans.length()){
                ans=temp;
            }
            temp = Helper(str,i,i+1);
            if(temp.length()>ans.length()){
                ans=temp;
            }
        }
        return ans;
	}
    
    public static String Helper(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}

