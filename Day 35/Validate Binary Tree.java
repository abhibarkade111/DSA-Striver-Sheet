// Validate Binary Tree

// Approach : MIN-MAX Method 
// reursively check the the node is between the range 
// Initial range is [MIN,MAX]
// left  - range is [MIN,root.val]
// right - range is [root.val, MAX]

// if any node violated the condtion then return false
// else return true

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

class Solution {
    public boolean check(TreeNode root, long lower, long upper){
        if(root==null) return true;
        if(root.val<=lower || root.val>=upper) return false;
        return check(root.left, lower, root.val) &&  check(root.right, root.val, upper);
        
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}