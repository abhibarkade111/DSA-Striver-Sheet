	// Populate Next Right pointers of Tree

    // We need attach the nodes on the same level by next pointer is given
    
    // Approach 1: Using Level Order Tarversal

    // Attach the next pinter to the q.peek() and at the end attach it to null

    // Code:

    
    /*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	// Write your code here.
        if(root==null) return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            BinaryTreeNode curr=null;
            for(int i=0;i<size;i++){
                curr = q.poll();
                curr.next = q.peek();
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            curr.next=null;
        }
        
	}
}