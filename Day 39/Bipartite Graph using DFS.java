// Bipartite Graph using BFS 

// Approach :
// Bipartite Grpah :- Graph is coloured using only two color i.e no two adjacent nodes have a same color 

// We use a color array and fill it by -1
// while we visit node then the adjacent nodes of that nodes are not visited then we visit it and color it using opposite color of node
// if nodes alraedy visted then check the nodes have no same color if same color tehn return false

// Time Complexity - O(N+E)
// Space Complexity - O(N+E) + O(N) + O(N)
// Code:

public class Solution {
    
    public static boolean checkDfs(int node, ArrayList<ArrayList<Integer>> adj, int col[]){
        if(col[node]==-1) col[node] = 1;
        for(int i : adj.get(node)){
            if(col[i]==-1){
                col[i] = 1-col[node];
                if(!checkDfs(i,adj,col)) return false;
            }
            else if(col[node]==col[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<edges.size();i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.size();i++){
            for(int j=0;j<edges.size();j++){
                if(edges.get(i).get(j)==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int col[] = new int[edges.size()];
        Arrays.fill(col, -1);
        for(int i=0;i<edges.size();i++){
            if(col[i]==-1){
                if(!checkDfs(i,adj,col)) return false;
            }
        }
        return true;
    }
}