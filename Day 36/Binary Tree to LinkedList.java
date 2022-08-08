// Binary Tree to LinkedList 

// Convert Binary Tree to the DLL
// Inorder of the Binary tree convert to the DLL

// Approach 1: Brute Force
// Save the inorder in DS and convert it into the DLL

// Approach 2: Without using any Extra space

// Do inorder traversal and add nodes left to the prev and prev right to the node

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

public class Solution {
	static BinaryTreeNode<Integer> prev=null, nroot=null;
    public static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root){
        if(root==null) return null;
        solve(root.left);
        if(prev==null) nroot = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        solve(root.right);
        return nroot;
    }
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
        prev=null;
        nroot=null;
        return solve(root);
	}
}