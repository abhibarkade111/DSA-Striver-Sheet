// Rat in Maze problem
// Given us the arrray contain multiple path from (0,0) to (n-1,n-1)

// Approach :
// Use Recursion and continusly check for each way also carry one visited array to check whther the vertex is visited or not

// Time Complexity: O(4^(m*n))
// Space Complexity: O(N)+O(N)

// Code:
// GFG

public static void solve(int i,int j,int maze[][],int n,int vis[][],int di[],int dj[],ArrayList<ArrayList<Integer>> ans){
        if(i==n-1 && j==n-1){
            ArrayList<Integer> path = new ArrayList<>();
            for(int ia=0;ia<n;ia++){
                for(int ja=0;ja<n;ja++){
                    path.add(vis[ia][ja]);
                }
            }
            ans.add(path);
            return;
        }
        for(int ind=0;ind<4;ind++){
            int ni = i+di[ind];
            int nj = j+dj[ind];
            if(ni>=0 && nj>=0 && ni<n && nj<n && vis[ni][nj]==0 && maze[ni][nj]==1){
                vis[ni][nj]=1;
                solve(ni,nj,maze,n,vis,di,dj,ans);
                vis[ni][nj]=0;
            }
        }
    }

// CodeStudio

public class Solution {
    
    public static void solve(int i,int j,int maze[][],int n,int vis[][],int di[],int dj[],ArrayList<ArrayList<Integer>> ans){
        vis[i][j]=1;
        if(i==n-1 && j==n-1){
            ArrayList<Integer> path = new ArrayList<>();
            for(int ia=0;ia<n;ia++){
                for(int ja=0;ja<n;ja++){
                    path.add(vis[ia][ja]);
                }
            }
            ans.add(path);
            vis[i][j]=0;
            return;
        }
        for(int ind=0;ind<4;ind++){
            int ni = i+di[ind];
            int nj = j+dj[ind];
            if(ni>=0 && nj>=0 && ni<n && nj<n && vis[ni][nj]==0 && maze[ni][nj]==1){
//                 vis[i][j]=1;
                solve(ni,nj,maze,n,vis,di,dj,ans);
//                 vis[i][j]=0;
            }
        }
        vis[i][j]=0;
    }
    
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int di[] = new int[]{+1,0,0,-1};
        int dj[] = new int[]{0,-1,+1,0};
        int vis[][] = new int[n][n];
        if(maze[0][0]==1) solve(0,0,maze,n,vis,di,dj,ans);
        return ans;
    }
    
}    