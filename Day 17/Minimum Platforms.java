// Minimum Platforms
// Approach:
// steps: 1) Sort the both array individually
//        2) Now use two pinter approach one is used to travrse the arraival array and other is departure array
//        3) if arriavl time is less than the departure time increse the platform count else decrese the platform count
//        4) return the maximum platform count

// Time complexity - O(2NlogN) + O(2N)
// Space Complexity - O(1)

// Code 

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0,result=1,platform=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }
            else{
                platform--;
                j++;
            }
            result = Math.max(result, platform);
        }
        
        return result;
        
    }
    
}