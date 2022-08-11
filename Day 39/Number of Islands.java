// Number of Islands 

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Approach 1: Do the BFS Travrersal and check the adjacent 1's and count how many times bfs function is called

// Code:

class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int r, int c, char grid[][], int vis[][]){
        vis[r][c]=1;
        Queue<Pair> q = new LinkedList<>();
        int rowA[] = new int[]{0,0,1,-1};
        int colA[] = new int[]{1,-1,0,0};
        q.offer(new Pair(r,c));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int i=0;i<4;i++){
                int rr = row+ rowA[i];
                int cc = col+ colA[i];
                if(rr>=0 && cc>=0 && rr<grid.length && cc<grid[0].length && vis[rr][cc]==0 && grid[rr][cc]=='1'){
                        vis[rr][cc] =1;
                        q.offer(new Pair(rr,cc));
                    }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt+=1;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}

// Code on codeStudio 
// Eight directionally

// Code:


class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Solution 
{
    public static void bfs(int row, int col, int mat[][], int vis[][]){
        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r= p.row;
            int c= p.col;
            for(int delrow=-1; delrow<=1;delrow++){
                 for(int delcol=-1;delcol<=1;delcol++){
                      int rr = delrow+r;
                      int cc = delcol+c;
                     if(rr>=0 && cc>=0 && rr<mat.length && cc<mat[0].length && vis[rr][cc]==0 && mat[rr][cc]==1){
                    vis[rr][cc]=1;
                    q.offer(new Pair(rr,cc));
                }
                 }
             }
        }
    }
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int cnt=0;
        int vis[][] = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && vis[i][j]==0){
                    cnt+=1;
                    bfs(i,j,mat,vis);
                }
            }
        }
        return cnt;
    }
}