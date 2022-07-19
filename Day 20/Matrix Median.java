// Matrix Median
// Input: Matrix contains row sorted 
// Output: Median i.e middle element among all the element

// Approach 1: Brute Force 
// Copy the every element in the ArrayList
// Sort the ArrayList
// Return the middle Element

// Time Complexity - O((N*M)log(N*M))
// Space Complexity- O(N)

// Approach 2: Binary Search
// as in constraints given that the maximum element would be 1e5
// So our search space initially will be the 1 to 1e5
// Now we use the binary search find the how many elements less than it is present
// And same Binary search for the count how many elements prsent less that or equal to the mid in the each row of the matrix
// At the end return low because at low will be our answer

// Time Complexity- O(32*(N*logM))
// Space Complexity - O(1)

// Code:
import java.util.ArrayList;

public class Solution
{
    public static int countEle(ArrayList<Integer> row, int mid){
        int l=0;
        int h=row.size()-1;
        while(l<=h){
            int md = (l+h)>>1;
            if(row.get(md)<=mid){
                l=md+1;
            }
            else{
                h=md-1;
            }
        }
        return l;
    }
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        int low=1;
        int high=(int)1e5;
        while(low<=high){
            int mid = (low+high)>>1;
            int cnt=0;
            for(int i=0;i<matrix.size();i++){
                cnt+= countEle(matrix.get(i), mid);
            }
            if(cnt<=((matrix.size()*matrix.get(0).size())/2)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
	}
}