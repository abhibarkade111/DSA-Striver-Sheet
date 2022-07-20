// Min Heap 
// Properties of min heap: 1) Parent value is less than the child
//                         2) min heap is complete binary tree
//                         3) Node as left as possible

// Code:

class Heap{
    int size;
    int arr[] = new int[10000];
    Heap(){
        size=0;
        arr[0]=-1;
    }
    
    public void push(int val){
        size++;
        int index = size;
        arr[index] = val;
        
        while(index>1){
            int parent = index/2;
            if(arr[parent]>arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else{
                return;
            }
        }
    }
    public int pop(){
        if(size==0) return -1;
        int deleteElement = arr[1];
        arr[1] = arr[size];
        size--;
        
        int i=1;
        while(i<=size){
            int leftInd = 2*i;
            int rightInd = 2*i+1;
            int smaller = i;
            if(leftInd<=size && arr[leftInd]<arr[smaller]){
                smaller = leftInd;
            }
            if(rightInd<=size && arr[rightInd]<arr[smaller]){
                smaller = rightInd;
            }
            
            if(i==smaller) break;
            
            int temp = arr[smaller];
            arr[smaller] = arr[i];
            arr[i] = temp;
            i = smaller;
        }
        return deleteElement;
    }
}
public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Heap minheap = new Heap(); 
        for(int a[]:q){
            if(a[0]==0){
                minheap.push(a[1]);
            }
            else{
                ans.add(minheap.pop());
            }
        }
        int ansArr[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;

    }
}