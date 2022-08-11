// Clone a Graph 

// Input : Given a grpah we need to return the deep copy of the given graph
// Output: Copy of the original Graph

// Approach : Using DFS Travrsal we can travrse the graph and also carry a hashmap to check whether the node is already created or not if created then add it in list else create add in list and map

// Code:

class Solution {
    public Node dfs(Node node, HashMap<Node,Node> hm){
        List<Node> neighbors = new ArrayList<>();
        Node clone = new Node(node.val);
        hm.put(node,clone);
        for(Node n : node.neighbors){
            if(hm.containsKey(n)){
                neighbors.add(hm.get(n));
            }
            else{
                neighbors.add(dfs(n,hm));
            }
        }
        clone.neighbors = neighbors;
        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> hm = new HashMap<>();
        if(node.neighbors.size()==0){
            Node clone = new Node(node.val);
            clone.neighbors = node.neighbors;
            return clone;
        }
        return dfs(node,hm);
    }
}