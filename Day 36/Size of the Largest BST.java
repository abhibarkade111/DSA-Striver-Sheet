// Size of the Largest BST 

// output : number of nodes in largest valid binary tree

// Approach 1: Brute Force
// send every node to the validate binary tree function and calculate the maximum size
// return maximum size

// Approach 2: Max Min and Size maintain of every node
// return the max size

// Code:

class NodeValue{
    int min;
    int max;
    int size;
    NodeValue(int min, int max, int size){
        this.min= min;
        this.max = max;
        this.size = size;
    }
}
public class Solution {
    public static NodeValue helper(TreeNode<Integer> root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        if(left.max<root.data && root.data<right.min){
            return new NodeValue(Math.min(left.min, root.data), Math.max(right.max,root.data), left.size+right.size+1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
        return helper(root).size;
	}
}


// Leetcode Hard Problem 
// Maximum Sum BST in Binary Tree

// Code:

class NodeValue{
    int max;
    int min;
    int sum;
    
    NodeValue(int min, int max, int sum){
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}
class Solution {
    int maxSum=0;
    public NodeValue helper(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        if( left.max<root.val && root.val<right.min){
            maxSum = Math.max(maxSum,left.sum+right.sum+root.val);
            return new NodeValue(Math.min(left.min, root.val), Math.max(right.max, root.val), left.sum+right.sum+root.val );
            
        }
        
        maxSum = Math.max(maxSum, Math.max(left.sum, right.sum));
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}

// Time Complexity of both the solution is - O(n)
// Space Complexity - O(n)

