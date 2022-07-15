// Subset Sums
// Array or ArrayList given we need to find all possible subset and add each subset sum in the solution 
// Approach 1: Brute Force
// Power Set Algorithm to find the All the subset

// Approach 2: Optimal Approach (Recursion)
// Use Recursion to decide whether the element is pick or not 
// And add the sum at each base to the solution

// Time Complexity - O(2^N)
// Space Complexity - O(2^N)

// Code:
class Solution{
    void func(int ind,int sum,ArrayList<Integer> arr,int N,ArrayList<Integer> ans){
        if(ind==N){
            ans.add(sum);
            return;
        }
        func(ind+1,sum+arr.get(ind),arr,N,ans);
        func(ind+1,sum,arr,N,ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        func(0,0,arr,N,ans);
        Collections.sort(ans);
        return ans;
    }
}