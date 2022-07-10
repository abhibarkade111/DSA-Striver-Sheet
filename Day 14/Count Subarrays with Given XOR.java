// Count Subarrays with Given XOR
// Approach 1 : generate all permutaions of array using kedane's Algorithms
// Time Complexity - O(N^3)
// Space Complexity - O(1)

// Approach 2:- Using HashMap 
// Time Complexity - O(NlogN)
// Space Complexity - O(N)

// Code

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        int xorr=0;
        int n = arr.size();
        for(int i=0;i<n;i++){
            xorr = xorr ^ arr.get(i);
            if(hm.containsKey(xorr ^ x)){
                count+=hm.get(xorr ^ x);
            }
            if(xorr==x){
                count++;
            }
            if(hm.containsKey(xorr)){
                hm.put(xorr, hm.getOrDefault(xorr,0)+1);
            }
            else{
                hm.put(xorr,1);
            }
        }
        return count;
	}
}