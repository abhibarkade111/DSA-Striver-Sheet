// Longest SubArray Having sum is 0
// Approach 1: Optimal Approach
// Use HashMap to store the sum and index and accordingly traverse the array
// If Sum is exist in hahMap then nax = Math.max(i-hm.get(sum));
// Else hm.put(sum,i);
// Return max;

// Time Comlexity: O(N)
// Space Complexity: O(N)

// Code 

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
         int sum=0;
         int max=0;
         map.put(0,-1);
         for(int i=0;i<n;i++){
             sum=sum+arr[i];
             if(map.containsKey(sum)){
                  int len = i-map.get(sum);
                  max= Math.max(len, max);
             }
             else{
                 map.put(sum,i);
             }
         }
         return max;
    }
}