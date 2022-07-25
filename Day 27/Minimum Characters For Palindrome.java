// Minimum Characters For Palindrome
// Input: str = "abcd";
// Output: 3

// Approach 1: Brute Force
// delete the character at the end and check the string is palindrome or not
// continuoulsy delete the character from the back until string is palindrome or string becomes null
// return the number of character is deleted

// Time Complexity - O(n*n)
// Space Complexity - O(1)

// Approach 2: Using KMP Algorithm
// str = s+ "$" + s.reverse();
// find the lps array for the above string 
// and return the length of s - last element of the lps array

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:


public class Solution {
    public static int[] generateLPS(String ns){
        int n = ns.length();
        int lps[] = new int[n];
        for(int i=1;i<n;i++){
            int j = lps[i-1];
            while(j>0 && ns.charAt(i)!=ns.charAt(j)){
                j = lps[j-1];
            }
            if(ns.charAt(i)==ns.charAt(j)) j++;
            lps[i]=j;
        }
        return lps;
    }
    public static int minCharsforPalindrome(String str) {
        //Write your code here
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String ns = str+"$"+sb.toString();
        int lps[] = generateLPS(ns);
        return str.length()-lps[ns.length()-1];
    }

}