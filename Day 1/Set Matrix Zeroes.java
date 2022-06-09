// Brute Force Approach
// O((m*n)*(m+n) + m*n)
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean b = true;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    b=false;
                    for(int k=0;k<matrix.length;k++){
                        if(matrix[k][j]!=0) matrix[k][j]=-1;
                    }
                    for(int k=0;k<matrix[0].length;k++){
                        if(matrix[i][k]!=0) matrix[i][k]=-1;
                    }
                }
            }
        }
        if(!b){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1) matrix[i][j]=0;
            }
        }
        }
    }
}

// Second Approach by creating the two dummy arrays or row and columns Better Approch
// O(m*n + m*n)
class Solution{
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col=matrix[0].length;
        int rows[] = new int[row];
        int cols[] = new int[col];
        Arrays.fill(rows,-1);
        Arrays.fill(cols,-1);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rows[i]=cols[j]=0;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rows[i]==0 || cols[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }
}


// Third Approach is Optimal Appraoch 
// Take first row and first column as a dummy array and according to set the zeroes
// O(m*n + m*n)
class Solution{
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col=matrix[0].length;
        boolean cols = false;

        for(int i=0;i<row;i++){
            if(matrix[i][0]==0) cols = true;
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(cols) matrix[i][0]=0;
        }
    }
}