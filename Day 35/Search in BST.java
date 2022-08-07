// Search in BST
// we know that the bst have the smaller elements on the left and greater elements on the right 
// so if the key is grater than the root then we go on right else go on left if found return node

// code:

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
       while(root!=null && root.val!=val) root=root.val>val?root.left:root.right;
       return root;
    }
}


// Recursive solution

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
        if(root==null) return false;
        if(root.data==x) return true;
        if(root.data<x){
            return searchInBST(root.right,x);
        }
        else if(root.data>x){
            return searchInBST(root.left,x);
        }
        return false;
        
	}
}