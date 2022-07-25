// Count and Say
// Input: n = 4
// Output: "1211"
// Explanation:
// countAndSay(1) = "1"
// countAndSay(2) = say "1" = one 1 = "11"
// countAndSay(3) = say "11" = two 1's = "21"
// countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"


// Approach:
// We Recursively call the function until n=1 because n=1 is our base case 
// And count same digits using counter and in ansString as ansString+= String.valueOf(count)+str.charAt(i)
// return final string

// Time Complexity - O(n*s) s=length of string
// Space Complexity  - O(1)

// Code:

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String str = countAndSay(n-1);
        int s = str.length();
        if(s==1) return "11";
        int ct=1;
        String newStr = "";
        for(int i=0;i<s-1;i++){
            if(str.charAt(i)==str.charAt(i+1))ct++;
            else{
                newStr += String.valueOf(ct)+str.charAt(i);
                ct=1;
            }
        }
        newStr += String.valueOf(ct)+str.charAt(s-1);
        return newStr;
    }
}