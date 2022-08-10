// Detect Cycle Using BFS Algorithm

// Approch:
// Using a Queue Data Structure and Parent node pair we can do the bfs traversal and detect cycle is present
// Node and Parent node save in queue and do travrsing in the graph also maintain the visited array

// Code:

import java.util.*;
class Pair{
    int node;
    int parent;
    Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
public class Solution {
    public static boolean detect(int node,ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node]=true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i : adj.get(p.node)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(new Pair(i,p.node));
                }
                else if(p.parent!=i){
                    return true;
                }
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
            if(!vis[i] && detect(i,adj,vis)){
                return "Yes";
            }
        }
        return "No";
    }
    
}