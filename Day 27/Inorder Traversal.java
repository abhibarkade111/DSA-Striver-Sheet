// Inorder Traversal
// Input: root = [1,null,2,3]
// Output: [1,3,2]

// Approach 1: Recusrsive
// Inorder-> Left Root Right

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
}

// Approach 2: Iterative
// Inorder-> Left Root Right

// Use stack 
// if root!=null then add node in stack else pop it from stack add it in ans and root become the popped element and call the root.right

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/
public class Solution {
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                ans.add(st.peek().data);
                root = st.pop().right;
            }
        }
        return ans;
    }
}