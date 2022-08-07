// Check Binary tree of mirror of itself

// Approach : Using level order travrsal swap the left and right node of the each node
// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                if(curr!=null){
                    Node n = curr.left;
                    curr.left = curr.right;
                    curr.right = n;
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
    }
}