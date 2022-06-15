// Search given target in given 2D matrix 
// Some Special Conditions are given in matrix i.e Rows are sorted
//                                                 first element of the row is greater than the last element of the previous row 
// we can solve by problem using by three approaches
// 
// approach 1 -brute force
// linearly travers the array and search the target
// time complecity-O(M*N)

// approach 2
// place pointers at last element of first row and travers back 
// according to target move back or down

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i=0;
        int j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
        
    }
}

// approach 3
// optimal approach for special cases given on leet code
// if we read data row by row then array is sorted 
// we use binary search to search element
// time compecity O(logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        
        int low=0;
        int high=(m*n)-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[mid/m][mid%m]==target)
            {
                return true;
            }
            if(matrix[mid/m][mid%m]<target)
            {
              low=mid+1; 
            }
            else
            {
                high=mid-1;
            }         
        }
         return false; 
    }
}



// Another Solution 

        int i=0;
        for( i=0;i<matrix.length;i++){
            if(matrix[i][0]>target){
                break;
            }
        }
        if(i==0 ){
            return false;
        }
        
        for(int j=0;j<matrix[i-1].length;j++){
            if(matrix[i-1][j]==target){
                return true;
            }
        }
        return false;