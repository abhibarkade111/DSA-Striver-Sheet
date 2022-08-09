// BFS Traversal of Graph 

// Input : Graph
// Output: BFS Traversal

// Approach 1: Using Queue Data Structure

// Code:

public class Solution {
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        ans.add(node);
        while(!q.isEmpty()){
            Collections.sort(adj.get(q.peek()));
            for(int i : adj.get(q.poll())){
                if(!vis[i]){
                    vis[i] = true;
                    ans.add(i);
                    q.add(i);
                }
            }
        }
    }
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){
		// WRITE YOUR CODE HERE
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[vertex];
        for(int i=0;i<vertex;i++){
            adj.add(new ArrayList<>());
        }
         for(int i=0;i<edges[0].length;i++){
            adj.get(edges[1][i]).add(edges[0][i]);
            adj.get(edges[0][i]).add(edges[1][i]);
        }
        for(int i=0;i<vertex;i++){
            if(!vis[i]){
                bfs(i,adj,vis,ans);
            }
        }
        return ans;
	}
}


// Code:

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public void bfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        // ans.add(node);
        vis[node] = true;
        q.add(node);
        while(!q.isEmpty()){
            ans.add(q.peek());
            for(Integer i : adj.get(q.poll())){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ans=  new ArrayList<>();
        
        bfs(0, vis, adj, ans);

        return ans;
    }
}