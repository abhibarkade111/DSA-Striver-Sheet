// Kth Largest element in stream

// Input : Given a continuous elements of data stream 
// output: return kth largest element at any time

// Approach : Heap
// We Use PriorityQueue Data Structure

// if pq.size()>size then pq.poll()

// return pq.peek()

// Code:

public class Kthlargest {
    PriorityQueue<Integer> pq;
    int size;
    Kthlargest(int k, int[] arr) {
        // Write your code here.
        pq = new PriorityQueue<>();
        int size=k;
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size()>size){
                pq.poll();
            }
        }
    }

    void add(int num) {
        // Write your code here.
        pq.add(num);
        if(pq.size()>size){
            pq.poll();
        }
    }

    int getKthLargest() {
        // Write your code here.
        if(!pq.isEmpty())  return pq.peek();
        return -1;
    }
}
