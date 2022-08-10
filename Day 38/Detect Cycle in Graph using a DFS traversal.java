// Detect Cycle in a Graph using a DFS Traversal

// Approach 1:

// Do the DFS Traveral and pass the parent node and node and check the node is already visited or not if already visited and node != parent then cycle is detected 

// Code:

public class Solution {
    public static boolean detect(int node,int parent,ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        vis[node] = true;
        for(int i: adj.get(node)){
            if(!vis[i]){
                if(detect(i,node,adj,vis)) return true;
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[] = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                if(detect(i,-1,adj,vis)){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    
}