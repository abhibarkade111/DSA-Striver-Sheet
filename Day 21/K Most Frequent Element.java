// K Most Frequent Element  
// Input: [1,1,1,2,2,3] and k=2;
// Output: [1,2]

// Code: 

public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		// Write your code here.
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int it: arr){
            hm.put(it,hm.getOrDefault(it,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> hm.get(a)-hm.get(b));
        for(int key: hm.keySet()){
            pq.add(key);
            if(pq.size()>k) pq.poll();
        }
        int ans[] = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.poll();
        }
        return ans;
	}

}
