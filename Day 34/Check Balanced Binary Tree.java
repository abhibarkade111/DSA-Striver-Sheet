// Check for Balnaced Binary Tree 
// Balanced Binary tree - differ between the height of left subtree and height right subtree should not be greater than 1

// Approch 1: Brute Force
// Calculate the height of ecah node left and right height and compare if diff is grter than 1 return false
// else return true

// Time Complexity  - O(n*n)
// Space Complexity - O(n*n)

// Approach 2: Same as the we calculate the height and binary tree
// Just we chek if anywhree the diff is grter than 1 if it is then reurn -1 enyirely
// catch -1 if it is return true
// return true

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

class Solution {
    public int check(TreeNode root){
        if(root==null) return 0;
        int lh = check(root.left);
        if(lh==-1) return -1;
        int rh = check(root.right);
        if(rh==-1) return -1;
        
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(check(root)==-1) return false;
        return true;
    }
}