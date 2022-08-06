// Check Identical Trees 

// Approach 1: Trevrse the both trees and check the nodes and values are same or not if same return true else return false

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code 

// Leetcode

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Code Studio


public class Solution {
    
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write you code here.     
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(!root1.data.equals(root2.data)) return false;
        return  identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);
    }

}