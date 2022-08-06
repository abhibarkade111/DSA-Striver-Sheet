// Diameter of Binary Tree 
// Diameter - Longest path between the two nodes
//          - No need that the path will be pass from the root

// Approach 1: Brute Force
// Calculate the Height for at each node left + right and return the max of it

// Time Complexity - O(n*n)
// Space Complexity - O(n)

// Approach 2: Optimal Approach Recursive
// calculate the left + right in same recursion

// Time Complexity  - O(n)
// Space Complexity - O(n)

// Code

public class Solution {
    public static int findD(TreeNode<Integer> root, int max[]){
        if(root==null) return 0;
        int lh = findD(root.left, max);
        int rh  = findD(root.right, max);
        max[0] = Math.max(max[0], lh+rh);
        return 1+Math.max(lh,rh);
    }
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
        int max[]=new int[1];
        max[0]=0;
        findD(root, max);
        return max[0];
	}
}
