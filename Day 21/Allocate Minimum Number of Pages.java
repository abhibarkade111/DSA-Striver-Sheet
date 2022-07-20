// Alloacate Minimum number of Pages
// Number of students and books array are given having pages
// We need to return minimum number of pages

// Condition: One book assigned to only one student
//            Books should be allocted contiguously

// Approach : Binary Search
// initailaly our search space will be low  = minimum element from the array and high = sum of element of array
// Accordingly calculate the mid and check is possible to alloacate the books to M student by considering the barrier

// Time Complexity - O(N*logN)
// Space Complexity - O(1)

//Code:

class Solution 
{
    //Function to find minimum number of pages.
    public static boolean isPossible(int barrier,int N, int A[]){
        int pages=0;
        int allocStudent=1;
        for(int i=0;i<A.length;i++){
            if(A[i]>barrier) return false;
            if(pages+A[i]>barrier){
                allocStudent++;
                pages=A[i];
            }
            else{
                pages+=A[i];
            }
            // if(allocStudent>N) return false;
        }
        if(allocStudent>N) return false;
        return true;
        
    }
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int low=Integer.MAX_VALUE,high=0;
        for(int i=0;i<N;i++){
            if(low>A[i]) low = A[i];
            high+=A[i];
        }
        int res=-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(isPossible(mid,M,A)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
}