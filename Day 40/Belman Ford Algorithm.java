// Belman Ford Algorithm 
// Belman Ford Algorithm used to find the shortest path between source to the destination it works on negative weight edges as well
// Djkstra algorithm not work on the negative edges

// Approach 1: 1) initialize the dist array, fill all values as 1e9
//             2) assign dist[source]=0;
//             3) Now do the N-1 times traversing of the edges and update the distance if following below conditions
//                condition : if( dist[u]+w < dist[v]) then dist[v] = dist[u]+w;
//             4) return the dist[destination]

// Time Complexity - O(N-1)*O(E)
// Space Complexity - O(N)

// Code:

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        int dist[] = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S]=0;
        for(int i=1;i<=V-1;i++){
            for(ArrayList<Integer> arr : adj){
                if(dist[arr.get(0)]+arr.get(2)<dist[arr.get(1)]){
                    dist[arr.get(1)] = dist[arr.get(0)]+arr.get(2);
                }
            }
        }
        return dist;
    }
}