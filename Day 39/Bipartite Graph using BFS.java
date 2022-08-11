// Bipartite Graph using BFS 

// Approach :
// Bipartite Grpah :- Graph is coloured using only two color i.e no two adjacent nodes have a same color 

// We use a color array and fill it by -1
// while we visit node then the adjacent nodes of that nodes are not visited then we visit it and color it using opposite color of node
// if nodes alraedy visted then check the nodes have no same color if same color tehn return false

// Time Complexity - O(N+E)
// Space Complexity - O(N+E) + O(N) + O(N)
// Code:

class Solution {
    public boolean check(int node, int graph[][], int col[]){
        Queue<Integer> q = new LinkedList<>();
        if(col[node]==-1) col[node] = 1;
        q.offer(node);
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i : graph[n]){
                if(col[i]==-1){
                    q.offer(i);
                    col[i]=1-col[n];
                }
                else if(col[i]==col[n]){
                    return false;
                }
            }
        }
        return true;
    } 
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);
        for(int i=0;i<graph.length;i++){
            if(!check(i,graph,col)) return false;
        }
        
        return true;
    }
}