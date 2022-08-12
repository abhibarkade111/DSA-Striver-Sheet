// Strongly Connected Components 
// Kosaraju's Algorithm 

// Approach 1:

// We can solve the Strongly Connected Components problem using Kosaraju Algorithm

// Alogorithm : Steps 1) FInd the Topological sort
//                    2) Transpose the Graph
//                    3) Do Dfs on transposed graph and using Topological sort and add list in ans
// Return ans

// Code:

import java.util.*;
public class Solution {

    public static void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, boolean vis[],List<Integer> list){
        vis[node] = true;
        list.add(node);
        for(int i : transpose.get(node)){
            if(!vis[i]){
                revDfs(i,transpose,vis,list);
            }
        }
    }
    public static void dfsTopo(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> st){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfsTopo(i,adj,vis,st);
            }
        }
        st.push(node);
    }
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfsTopo(i,adj,vis,st);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i=0;i<n;i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            vis[i]=false;
            for(int it : adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                List<Integer> list = new ArrayList<>();
                revDfs(node,transpose,vis,list);
                ans.add(list);
            }
        }
        return ans;
    }
}