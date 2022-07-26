// Postorder Traversal
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Approach 1: recursive
// Left Right Root

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
    public void postorder(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }
}

// Approach 2: Iterative Using Two Stack

// Travrse an enter the element in one stack and if null found then pop the element and enter in the second stack
// And then add all element int list from the second stack
// return the list

// Time Complexity - O(2n)
// Space Complexity - O(2n)

// Approach 3: Using only one stack

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
    public static List < Integer > getPostOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null ||!st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp==null){
                    temp = st.pop();
                    ans.add(temp.data);
                    while(!st.isEmpty() && st.peek().right==temp){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return ans;
    }
}