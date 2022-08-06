// Lowest Common Ancecstor 

// Approach 1: Brute Force

// Calculate the path for each node and return the last common node
// Time Complexity - O(n)+O(n)+o(n)+O(n)
// Space Complexity - O(2n)

// Approach 2 : Recursive
// if node found we return a root
// else if leftVal and rightVal both have found a  node then we return node
// if any one of the null then we return non null node

// Time Complexity  - O(n)
// Space Complexity - O(n)

// Code:

// Leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
     }
}


// Code Studio

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        //    Write your code here.
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(root.data== x || root.data==y) return root.data;
        int left = lowestCommonAncestor(root.left,x,y);
        int right = lowestCommonAncestor(root.right,x,y);
        if(left==Integer.MIN_VALUE) return right;
        else if(right==Integer.MIN_VALUE) return left;
        else return root.data;
    }
}
