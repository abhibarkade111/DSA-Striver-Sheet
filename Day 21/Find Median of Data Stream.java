// Find Median of Data Stream
// Input: arr = [6,2,1,3,7,5]
// Output: [6,4,2,2,3,5]

// Appraoch: Use PriorityQueue to find the runnig median
// Use MinHeap and MaxHeap to maintain the median and even for checking two elements or single elements

// Time Complexity - O(N+N)
// Space Complexity - O(N)

// Code:
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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */