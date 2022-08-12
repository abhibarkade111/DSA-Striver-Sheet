MST using Prims Algorithm

// Approach :

// Algorithm
// 1) Initialize the parent array set to -1, mst array set to false, key array set to infinity
// 2) key[0]=0;
// 3) Use PrioritQueue Data Structure to find the shortest distance each time 
// 4) iterate through this diatance if any small distance find than the already exists valu in key array upadate it
// 5) Return the cost of the minimum spanning tree 

// Time Complexity - O(N*logN)
// Space Compleity - O(N) +O(N) 

// Code:

class Node implements Comparator<Node>{
    int v;
    int w;
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    Node(){}
    int getV(){
        return v;
    }
    int getW(){
        return w;
    }
    
    @Override 
    public int compare(Node n1, Node n2){
        if(n1.w>n2.w){
            return 1;
        }
        if(n1.w<n2.w){
            return -1;
        }
        return 0;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        ArrayList<ArrayList<Node>> adjN = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjN.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                adjN.get(i).add(new Node(adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
            }
        }
        int key[] = new int[V];
        boolean mst[] =new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>(V,new Node());
        pq.add(new Node(0,key[0]));
        while(!pq.isEmpty()){
            int u = pq.poll().getV();
            mst[u] = true;
            for(Node it : adjN.get(u)){
                if(!mst[it.getV()] && it.getW()<key[it.getV()]){
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getW();
                    pq.add(new Node(it.getV(),key[it.getV()]));
                }
            }
        }
        
        int ans=0;
        for(int i : key) ans+= i;
        return ans;
        
    }
}


// Code:

class Node implements Comparator<Node>{
    int v;
    int w;
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    Node(){}
    @Override 
    public int compare(Node n1, Node n2){
        if(n1.w>n2.w){
            return 1;
        }
        if(n1.w<n2.w){
            return -1;
        }
        return 0;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int key[] = new int[V];
        boolean mst[] =new boolean[V];
        // int parent[] = new int[V];
        // Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>(V,new Node());
        pq.add(new Node(0,key[0]));
        while(!pq.isEmpty()){
            int u = pq.poll().v;
            mst[u] = true;
            for(ArrayList<Integer> it : adj.get(u)){
                if(!mst[it.get(0)] && it.get(1)<key[it.get(0)]){
                    // parent[it.getV()] = u;
                    key[it.get(0)] = it.get(1);
                    pq.add(new Node(it.get(0),key[it.get(0)]));
                }
            }
        }
        
        int ans=0;
        for(int i : key) ans+= i;
        return ans;
        
    }
}
