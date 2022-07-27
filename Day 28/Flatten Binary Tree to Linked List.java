// Flatten Binary Tree to Linked List 
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

// Approach 1: Recursive
// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right = prev;
        prev = root;
    }
    
// Approach 2: Iterative Uisng Stack
// Time Complexity - O(n)
// Space Complexity - O(n)

    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);
            if(!st.isEmpty()){
                curr.left=null;
                curr.right = st.peek();
            }
        }
    }
    
// Approach 3: Morris Traversal Approach
// Time Complexity - O(n)
// Space Complexity  - O(1)
    
    public void flatten(TreeNode root) {
        TreeNode prev = null;
        while(root!=null){
            if(root.left!=null){
                prev = root.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left=null;
            }
            root = root.right;
            
        }
    }