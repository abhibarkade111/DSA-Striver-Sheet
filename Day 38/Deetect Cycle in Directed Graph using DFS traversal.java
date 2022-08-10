// Detect Cycle in a Graph using a DFS Traversal

// Approach 1:

// Using Visited and dfsVisited Array we can detect the cycle is present int graph or not
// using recusrsion and backtracking we can travrse the graph using DFS Travrsal

// Code:

public class Solution {
  public static boolean detect(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean dfsVis[]){
      vis[node] = true;
      dfsVis[node] = true;
      for(int i : adj.get(node)){
          if(!vis[i]){
              if(detect(i,adj,vis, dfsVis)) return true;
          }
          else if(dfsVis[i]) return true;
      }
      dfsVis[node] = false;
      return false;
  }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0;i<=n;i++){
          adj.add(new ArrayList<>());
      }
      for(int i=0;i<edges.size();i++){
          adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      }
      boolean vis[] = new boolean[n+1];
      boolean dfsVis[] = new boolean[n+1];
      
      for(int i=1;i<=n;i++){
          if(!vis[i]){
              if(detect(i,adj, vis, dfsVis)) return true;
          }
      }
      return false;
  }
}