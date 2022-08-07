// Lowest Common Ancestor of a Binary Search Tree

// In BST three condition : 1) if root.val< p.val and root.val<q.val => move to right
//                          2) else if root.val> p.val and root.val> q.val => move to left
//                          3) else return root

// Time Complexity - O(h)
// Space Complexity - O(1)


// Approach 1: recursion

// Code:

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}

// Approach 2: iterative

// Code: 

public class Solution 
{
	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {
        if(root==null) return null;
        while(root!=null){
            if(root.data<p.data && root.data<q.data) root = root.right;
            else if(root.data>p.data && root.data>q.data) root=root.left;
            else return root;
        }
        return null;
	}
}
