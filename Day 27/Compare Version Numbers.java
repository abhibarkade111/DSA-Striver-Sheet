// Compare Version Numbers
// Input: version1 = "1.01", version2 = "1.001"
// Output: 0
// Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".


// Approach:
// We just recover the number from the strings in between the . and compare both are equal or not and return accordingly

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i=0,j=0;
        while(i<m || j<n){
            int x=0;
            for(;i<m&& version1.charAt(i)!='.';i++){
                x = x*10 + (version1.charAt(i)-'0');
            }
            i++;
            
            int y=0;
            for(;j<n && version2.charAt(j)!='.';j++){
                y = y*10 +(version2.charAt(j) -'0');
            }
            j++;
            
            if(x!=y){
                return x>y?1:-1;
            }
        }
        return 0;
    }
}