// Detect Cycle in Undirected Graph Uising BFS 

// Approach : Using BFS Travrsing a graph we can detect the cycle in the Graph
// We store the node and parent pair in queue
// if any node is already visited then we can check its parent is a itself node if it then no cycle till now
// else already node visited by any other node so their is cycle is present

// Time Complexity - O(N+E)
// Space Complexity - O(N+E)

// Code:

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
