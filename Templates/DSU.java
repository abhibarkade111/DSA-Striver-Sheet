class DSU{
    int rank[];
    int parent[];
    DSU(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }

    int findParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int u, int v){
        int p_u = findParent(u);
        int p_v = findParent(v);
        if(p_u==p_v) return;
        if(rank[p_u]<rank[p_v]) parent[p_u] = p_v;
        else if(rank[p_u]>rank[p_v]) parent[p_v] = p_u;
        else{
            parent[p_v] = p_u;
            rank[p_u]+=1;
        }
    }
    
    void breakBond(int node){
        parent[node] = node;
    }
}