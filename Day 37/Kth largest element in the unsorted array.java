// Kth largest element in the unsorted array

// Approach 1: Sort and return

// Approach 2: Using PriorityQueue

// Code:

public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		// Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.add(i);
            if(pq.size()>K) pq.poll();
        }
        return pq.peek();
	}
}

// Approach 3: Optimal Approach - Quick Select 
// Quicke Select is based on the Quick Sort 
// Randomized pivot selection techinique to optimize this approach
