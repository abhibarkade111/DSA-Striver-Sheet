// Reverse the word in given string
// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Approach 1: Brute Force
// Traverse the string and find the frist char and then the find the end upto space and add string in the st
// again pop element from the stack

// Time Complexity -O(n)
// Space Complexity - O(n)

// Code:

class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int start=0,end=0,i=0;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)==' ') i++;
            start=i;
            while(i<s.length() && s.charAt(i)!=' ') i++;
            end=i;
            st.push(s.substring(start,end));
        }
        String ans="";
        while(!st.isEmpty()){
            ans+= st.pop()+" ";
        }
        return ans.trim();
    }
}

// Approach 2: O(1) space

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

class Solution {
    public String reverseWords(String s) {
        int start=0,end=0,i=0;
        String ans="";
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)==' ') i++;
            start=i;
            while(i<s.length() && s.charAt(i)!=' ') i++;
            end=i;
            ans= s.substring(start,end)+" "+ans;
        }
        
        
        return ans.trim();
    }
}


// Approach 3: Using Inbuilt method split

// Time Complexity- O(n)
// Space Complexity- O(n)

// Code:

class Solution {
    public String reverseWords(String s) {
        int start=0,end=0,i=0;
        String ans="";
        String arr[] = s.split("\\s+");
        for(String str : arr){
            String a = str.trim();
            if(!a.equals(" "))ans= a+" "+ ans;
            ans.trim();
        }
        
        return ans.trim();
    }
}

// Code Studio Code

public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
        StringBuilder sb = new StringBuilder();
        str.trim();
        String s[] = str.split(" ");
        for(int i=s.length-1;i>=0;i--){
            sb.append(s[i].trim()+" ");
        }
        return sb.toString();
	}
}

