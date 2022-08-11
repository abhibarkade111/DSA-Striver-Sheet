// Topological Sort using BFS Algorithm 

// Approach :

// We use BFS Algorithm and queue to find the Topological sort 
// initia; find the indegree of each node
// if indegree of any node is 0 then add it in stack and travrse for the that node and reduce the indegree for that node 
// indegree of node - number of egdes directed to the that node

// Code:

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int ans[] = new int[V];
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ind=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[ind++] = node;
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        
        return ans;
    }
}
