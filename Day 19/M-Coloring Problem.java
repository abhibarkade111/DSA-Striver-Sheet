// M-Coloring problem
// We need color the graph at max given color so that no adjacent node have the same color 
// If Possible then return 1, else return 0

// Approach : Use Recusrion 
// Try for each node checking it is possible to color it if not possible then try to use other color after all possible combination none of the gives answer return 0
// If any combination gives the correct answer return 1

// Code:
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[] = new int[n];
        if(solve(0,graph,m,n,color)) return true;
        return false;
    }
    
    public boolean solve(int node,boolean graph[][],int m,int n,int color[]){
        if(node==n) return true;
        for(int i=1;i<=m;i++){
            if(isSafe(node,graph,i,color,n)){
                color[node]=i;
                if(solve(node+1,graph,m,n,color)) return true;
                color[node]=0;
            }
        }
        return false;
    }
    
    public boolean isSafe(int node,boolean graph[][],int col,int color[],int n){
        for(int i=0;i<n;i++){
            if(graph[node][i] && color[i]==col) return false;
        }
        return true;
    }
}