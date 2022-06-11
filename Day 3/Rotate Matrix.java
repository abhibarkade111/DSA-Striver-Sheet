// Rotate Given matrix by 90 degree 
// Two Approaches : 1) use extra matrix and copy frist as the last column of new matrix and accordingly copy entire matrix
//                  2) Frist find transpose of matrix and then reverse the each row of the matrix

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}


// 2nd problem is rotate the each element of the matrix by 90 degree
// Using ArrayList
public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        
        int row=0;
        int col=0;
        int prev, curr;
        while(row<n && col<m){
            if(row+1==m || col+1==n){
                break;
            }
            prev = mat.get(row+1).get(col);
            for(int i=col;i<m;i++){
                curr = mat.get(row).get(i);
                mat.get(row).set(i,prev);
                prev =curr;
            }
            row++;
            
            for(int i=row;i<n;i++){
                curr = mat.get(i).get(m-1);
                mat.get(i).set(m-1, prev);
                prev=curr;
            }
            m--;
            if(row<n){
                for(int i=m-1;i>=col;i--){
                    curr = mat.get(n-1).get(i);
                    mat.get(n-1).set(i,prev);
                    prev = curr;
                }
            }
            n--;
            if(col<m){
                for(int i=n-1;i>=row;i--){
                    curr = mat.get(i).get(col);
                    mat.get(i).set(col,prev);
                    prev = curr;
                }
            }
            col++;
            
        }
    }