// Permutation Sequence 
// Input: n=3, k=3 
// Output: "213"

// Appraoch 1: brute Force 
// Use Recursion to genearate the all the permuation
// Then sort the permuataion 
// then return k-1 position element among the permutations

// Time Complexity - O(N!*N)

// Approach 2: Optimal Approach
// Use Mathematical Calculations
// i.e suppose K=4 then it will genearte 24 permurtatons and we want the the 17 then it is from the third digit from the sorted array
//  Do the same for the remaining digits 

// Time Compelexity - O(N^2)
// Space Complexity - O(N)

// Code:

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        int fact =1;
        for(int i=1;i<n;i++){
            fact = fact*i;
            num.add(i);
        }
        num.add(n);
        k=k-1;
        String ans="";
        while(true){
            ans+= num.get(k/fact);
            num.remove(k/fact);
            if(num.size()==0) break;
            k=k%fact;
            fact = fact/num.size();
        }
        return ans;
    }
}