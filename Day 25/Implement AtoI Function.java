// Implement atoi function
// Function which is present in the c/c++

// Input: s = "4193 with words"
// Output: 4193

// Approach 1:

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code :


public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        int result=0;
        int sign=1;
        int n = str.length();
        int i=0;
        while(i<n && str.charAt(i)==' '){
          i++;  
        } 
        if(i<n && str.charAt(i)=='+'){
            sign=1;
            i++;
        }
        else if(i<n && str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        while(i<n){
            if(Character.isDigit(str.charAt(i))){
                int digit = str.charAt(i)-'0';
                if(result> Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit> Integer.MAX_VALUE%10)){
                   return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result = result*10+digit;
                i++;
            }
            else{
                i++;
            }
        }
        return sign*result;
    }
}

