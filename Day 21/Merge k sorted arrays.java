// Merge K Sorted Arrays
// Input: Given K sorted arrays
// Output: Merge K arrays

// Approach: Use PriorityQueue 
// Use PriorityQueue add all the elememnts in PriorityQueue and then add all the elements in ArrayList from PriorityQueue

// Code:

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            for(int j=0;j<kArrays.get(i).size();j++){
                pq.add(kArrays.get(i).get(j));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
	}
}
