// Power Set

// Approach 1: Using Set bits we calculate the power Set


// Code 

public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<(int)Math.pow(2,arr.size());i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<arr.size();j++){
                if(((i>>j)&1)==1){
                    list.add(arr.get(j));
                }
            }
            ans.add(list);
        }
        return ans;
	}
}