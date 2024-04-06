// Maximum Width of Binary Tree
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9)

// Approach : Level Order Traversal
// Indexing the node while travrsing 
// insted of indexing serially we will index it by substracting min of that level from each level it will reduce the overflow as well it will help to pass corner test cases


// Time Complexity - O(n)
// Space Complexity - O(n)

// Leetcode Solution (null node considered)
// Code


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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int curr = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = curr;
                if(i==size-1) last = curr;
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*curr+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, 2*curr+2));
                }
            }
            ans = Math.max(ans, last-first+1);
            
        }
        return ans;
        
    }
}


// CodeStudio Solution (No Null node is considered)
// Code

/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.util.*;
public class Solution {
	public static int getMaxWidth(TreeNode root) {
		// Write your code here.
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ans = Math.max(ans, size);
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
	}
}