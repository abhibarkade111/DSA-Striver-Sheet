// Combination sum 
// Appraoch:
// Use PriorityQueue
// Add element to priority queue of size k if if size geretr than the then if new elemeent is greater than the peek then remove the peek and add the new element
// At end add all element in the arrayList and return

// Time Complexity - O(N*M+K)
// Space Complexity - O(K)

// Code:

public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i:a){
            for(int j:b){
                if(pq.size()<k)
                     pq.add(i+j);
                else{
                    if(i+j>pq.peek()){
                        pq.poll();
                        pq.add(i+j);
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            ans.add(0,pq.poll());
        }
        return ans;
	}
}