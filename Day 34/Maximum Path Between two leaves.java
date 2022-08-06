// Maximum Path Between two leaves 

// Approach 1: Same as we find the height of the tree and also check the balanced binary tree
// We find the max of node.val + lh+ rh 
// We when return we return math.max(lh,rh)+node.val


// Code 

// Leetcode

class Solution {
    public int find(TreeNode root,int maxi[]){
        if(root==null) return 0;
        int lh = Math.max(0,find(root.left, maxi));
        int rh = Math.max(0,find(root.right, maxi));
        
        maxi[0] = Math.max(maxi[0], root.val+lh+rh);
        return root.val+ Math.max(lh,rh);
    }
    public int maxPathSum(TreeNode root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        find(root, maxi);
        return maxi[0];
    }
}

// Code Studio

public class Solution {
    public static int find(TreeNode root, long maxi[]){
        if(root==null) return 0;
        if(root.left==null && root.right==null) maxi[1]++;
        int lh = Math.max(0, find(root.left, maxi));
        int rh = Math.max(0, find(root.right, maxi));
        maxi[0] = Math.max(maxi[0], lh+rh+root.data);
        return Math.max(lh,rh)+root.data;
    }
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        long maxi[] = new long[2];
        int count=0;
        maxi[0] = Long.MIN_VALUE;
        maxi[1]=0;
        find(root, maxi);
        if(maxi[1]==1) return -1;
        if(maxi[0]==Long.MIN_VALUE) return -1;
//         System.out.println("C="+count);
        return maxi[0];
	}
}

