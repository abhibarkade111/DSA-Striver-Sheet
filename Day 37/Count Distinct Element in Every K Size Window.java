// Count Distinct Element in Every K Size Window

// Approach : Using HashMap
// Using Hashmap we store the freequncy of k element while running drcrease the frequency of i and increase frequency of j
// return ans contains distinct size of each window

// Code:

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

		// Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.size()){
            if(j<k){
                hm.put(arr.get(j), hm.getOrDefault(arr.get(j),0)+1);
                j++;
                if(j==k){
                    ans.add(hm.size());
                }
            }
            else{
                hm.put(arr.get(j), hm.getOrDefault(arr.get(j),0)+1);
                hm.put(arr.get(i), hm.getOrDefault(arr.get(i),0)-1);
                if(hm.get(arr.get(i))==0) hm.remove(arr.get(i));
                ans.add(hm.size());
                i++;
                j++;
                
            }
        }
        return ans;
	}
}
