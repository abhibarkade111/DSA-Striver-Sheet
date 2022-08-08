// BST Iterator 

// BST Iterator Returns data in incresing order
// It has following functions: 1) hsNext(), 2) next(), 3) pushAll(), 4) Constructor

// Code:

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
}