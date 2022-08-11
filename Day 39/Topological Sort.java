// Topological Sort Using DFS Algorithm 

// Topological Sort - Suppose is a directed graph the edge between the u->v then u must appears before the v
// We can solve this problem using dfs algorithm and stack 

// after completion of all call for perticular node we can put it into the stack
// at the end pop all elements from the stack and return ans

// Code:

public class Solution 
{
    public static void topoDfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]) topoDfs(i,vis, adj,st);
        }
        st.push(node);
    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        Stack<Integer> st  = new Stack<>();
        boolean vis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topoDfs(i,vis,adj,st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) ans.add(st.pop());
//         System.out.println(ans);
        return ans;
    }
}
