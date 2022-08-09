// DFS Traversal of Graph

// Given : Graph 
// We need to return one of the traversal of the graph 

// Aproach 1: Recursive Solution 

// maintain boolean to check whether vertex is visited or not if !vis then vis and add it to solution 
// return ans;

// Time Complexity - O(N+E)
// Space Complexity  -O(N+E)

// Code:

public class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> arr){
        arr.add(node);
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(i, adj, vis, arr);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        boolean vis[] = new boolean[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                ArrayList<Integer> arr = new ArrayList<>();
                dfs(i, adj, vis, arr);
                ans.add(arr);
            }
        }
        return ans;
    }
}

// Code:

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        ans.add(node);
        vis[node]=true;
        for(Integer i: adj.get(node)){
            if(!vis[i]){
                dfs(i,vis,adj,ans);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,ans);
            }
        }
        return ans;
    }
}