// Find Median from Data Stream
// Input:
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]

// Approach 1: MinHeap and MaxHeap
// We Use PriorityQueue to find the medians

// carry boolean for checking the index is even ord odd

// Code:

import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean even = true;
        int ans[] = new int[n];
        int k=0;
        for(int i: arr){
            if(even){
                minHeap.add(i);
                maxHeap.add(minHeap.poll());
                ans[k] = maxHeap.peek();
                k++;
            }
            else{
                maxHeap.add(i);
                minHeap.add(maxHeap.poll());
                ans[k] = (minHeap.peek()+maxHeap.peek())/2;
                k++;
            }
            even=!even;
        }
        
        return ans;
    }
}


// Leetcode Hard:

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    boolean even = true;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even) return (minHeap.peek()+maxHeap.peek())/2.0;
        else return maxHeap.peek();
    }
}
