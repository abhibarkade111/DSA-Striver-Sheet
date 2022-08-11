// Detect Cycle in Directed graph using BFS 

// Approach 1: using topological sort we can detect the cycle in directed graph if we are able to do topological sort then no cycle is present else cycle is not present

// Time Complexity - O(N+E)
// Space Complexity - O(N)+O(N)

// Code:

public class Solution {
 
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0;i<=n;i++){
          adj.add(new ArrayList<>());
      }
      for(int i=0;i<edges.size();i++){
          adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      }
      int indegree[] = new int[n+1];
      Queue<Integer> q = new LinkedList<>();
      for(int i=1;i<=n;i++){
          for(int it :adj.get(i)){
              indegree[it]++;
          }
      }
      for(int i=1;i<=n;i++){
          if(indegree[i]==0){
              q.add(i);
          }
      }
      int count=0;
      while(!q.isEmpty()){
          count++;
          int node = q.poll();
          for(int it : adj.get(node)){
              indegree[it]--;
              if(indegree[it]==0) q.add(it);
          }
      }
      if(count==n) return false;
      return true;
  }
}