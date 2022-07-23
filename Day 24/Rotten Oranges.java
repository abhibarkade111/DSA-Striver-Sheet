// Rotten Oranges
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Approach 1: BFS
// Use Queue to store all initial rotten elements in queue and pop each element and check for 4 direction any fresh oranges if present then convert it into rotten and add it into int the queue and count all the elements entered in queue 
// Intially count the all oranges int the grid

// if total oaranges and inserted ornges are equal then return the countMin steps i. how many times we use BFS
// else retun -1

// Time Complexity - O(N*N)*4
// Space Complexity - O(N*N)

// Code:

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int cnt_fresh=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]!=0){
                    cnt_fresh++;
                }
            }
        }
        if(cnt_fresh==0) return 0;
        int dx[] = new int[]{0,0,1,-1};
        int dy[] = new int[]{1,-1,0,0};
        
        int cnt=0,countMin=0;
        while(!q.isEmpty()){
            int size=q.size();
            cnt+=size;
            for(int i=0;i<size;i++){
                int point[] = q.poll();
                for(int j=0;j<4;j++){
                    int x = point[0]+dx[j];
                    int y = point[1]+dy[j];
                    
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length ||  grid[x][y]==2 || grid[x][y]==0) continue;
                    grid[x][y]=2;
                    q.offer(new int[]{x,y});
                }
            }
            if(!q.isEmpty()) countMin++;
        }
        return cnt_fresh==cnt?countMin:-1;
    }
}